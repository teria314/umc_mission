package umc.mission.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.mission.common.apiPayload.code.status.ErrorStatus;
import umc.mission.common.apiPayload.exception.handler.FoodCategoryHandler;
import umc.mission.converter.MemberConverter;
import umc.mission.converter.MemberFavoriteFoodTypeConverter;
import umc.mission.domain.FoodType;
import umc.mission.domain.Member;
import umc.mission.domain.mapping.MemberFavoriteFoodType;
import umc.mission.repository.FoodTypeRepository;
import umc.mission.repository.MemberRepository;
import umc.mission.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodTypeRepository foodTypeRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDTO request) {
        Member newMember = MemberConverter.toMember(request);

        List<FoodType> foodTypeList = request.getPreferCategory().stream()
                .map(category->{
                    return foodTypeRepository.findById(category).orElseThrow(()-> new FoodCategoryHandler(ErrorStatus.FOOD_TYPE_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberFavoriteFoodType> memberFavoriteFoodTypeList = MemberFavoriteFoodTypeConverter.toMemberFavoriteFoodTypeList(foodTypeList);

        memberFavoriteFoodTypeList.forEach(memberFavoriteFoodType -> {memberFavoriteFoodType.setMember(newMember);});

        return memberRepository.save(newMember);
    }

}
