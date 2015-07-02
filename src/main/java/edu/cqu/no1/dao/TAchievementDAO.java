package edu.cqu.no1.dao;

import edu.cqu.no1.domain.TAchievement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

public interface TAchievementDAO extends BaseDao<TAchievement> {

    List findByAchievementIntroduction(Object achievementIntroduction);

    List findByAchievementOwner(Object achievementOwner);

    List findByAchievementName(Object achievementName);

    List findByAchievementJournal(Object achievementJournal);

    List findByAchievementVolume(Object achievementVolume);

    List findByAchievementType(Object achievementType);

    List findByAchievementPatent(Object achievementPatent);

    List findByIsdeleted(Object isdeleted);

    List findByUserdefine50(Object userdefine50);

    List findByUserdefine49(Object userdefine49);

    List findByUserdefine48(Object userdefine48);

    List findByUserdefine47(Object userdefine47);

    List findByUserdefine46(Object userdefine46);

    List findByUserdefine45(Object userdefine45);

    List findByUserdefine44(Object userdefine44);

    List findByUserdefine43(Object userdefine43);

    List findByUserdefine42(Object userdefine42);

    List findByUserdefine41(Object userdefine41);

    List findByUserdefine40(Object userdefine40);

    List findByUserdefine39(Object userdefine39);

    List findByUserdefine38(Object userdefine38);

    List findByUserdefine37(Object userdefine37);

    List findByUserdefine36(Object userdefine36);

    List findByUserdefine35(Object userdefine35);

    List findByUserdefine34(Object userdefine34);

    List findByUserdefine33(Object userdefine33);

    List findByUserdefine32(Object userdefine32);

    List findByUserdefine31(Object userdefine31);

    List findByUserdefine30(Object userdefine30);

    List findByUserdefine29(Object userdefine29);

    List findByUserdefine28(Object userdefine28);

    List findByUserdefine27(Object userdefine27);

    List findByUserdefine26(Object userdefine26);

    List findByUserdefine25(Object userdefine25);

    List findByUserdefine24(Object userdefine24);

    List findByUserdefine23(Object userdefine23);

    List findByUserdefine22(Object userdefine22);

    List findByUserdefine21(Object userdefine21);

    List findByUserdefine20(Object userdefine20);

    List findByUserdefine19(Object userdefine19);

    List findByUserdefine18(Object userdefine18);

    List findByUserdefine17(Object userdefine17);

    List findByUserdefine16(Object userdefine16);

    List findByUserdefine15(Object userdefine15);

    List findByUserdefine14(Object userdefine14);

    List findByUserdefine13(Object userdefine13);

    List findByUserdefine12(Object userdefine12);

    List findByUserdefine11(Object userdefine11);

    List findByUserdefine10(Object userdefine10);

    List findByUserdefine9(Object userdefine9);

    List findByUserdefine8(Object userdefine8);

    List findByUserdefine7(Object userdefine7);

    List findByUserdefine6(Object userdefine6);

    List findByUserdefine5(Object userdefine5);

    List findByUserdefine4(Object userdefine4);

    List findByUserdefine3(Object userdefine3);

    List findByUserdefine1(Object userdefine1);

    List findByUserdefine2(Object userdefine2);

}
