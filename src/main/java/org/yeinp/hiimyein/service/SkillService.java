package org.yeinp.hiimyein.service;

import org.yeinp.hiimyein.dto.MeDto;
import org.yeinp.hiimyein.dto.SkillDto;
import org.yeinp.hiimyein.dto.UserDto;
import org.yeinp.hiimyein.entity.Me;
import org.yeinp.hiimyein.entity.Skill;
import org.yeinp.hiimyein.entity.User;

import java.util.List;

public interface SkillService {
   default SkillDto skillEntityToSkillDto(Skill skill){
       return SkillDto.builder().id(skill.getId()).
               div(skill.getDiv()).
               skill(skill.getSkill()).
               build();
   }
    default Skill skillDtoToSkillEntity(SkillDto skillDto){
        return Skill.builder().id(skillDto.getId()).
                div(skillDto.getDiv()).
                skill(skillDto.getSkill()).
                build();
    }
    List<SkillDto> listSkill(String div);

   String insertSkill(SkillDto skillDto);


}
