package org.yeinp.hiimyein.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeinp.hiimyein.dto.MeDto;
import org.yeinp.hiimyein.dto.SkillDto;
import org.yeinp.hiimyein.entity.Me;
import org.yeinp.hiimyein.entity.Skill;
import org.yeinp.hiimyein.entity.User;
import org.yeinp.hiimyein.repository.MeRepository;
import org.yeinp.hiimyein.repository.SkillRepository;
import org.yeinp.hiimyein.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
   private SkillRepository skillRepository;

    @Override
    public List<SkillDto> listSkill(String div) {
        List<Skill> skillList = skillRepository.findByDiv(div);
        List<SkillDto> skillDtoList = new ArrayList<>();
        for(Skill skill : skillList){
            SkillDto skillDto = skillEntityToSkillDto(skill);
            skillDtoList.add(skillDto);
        }
        return skillDtoList;
    }

    @Override
    public String insertSkill(SkillDto skillDto) {

        Skill skill = skillDtoToSkillEntity(skillDto);
        Skill saveskill = skillRepository.save(skill);
        return saveskill.getId();
    }
}
