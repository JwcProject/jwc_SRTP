package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.TAchievementDAO;
import edu.cqu.no1.domain.TAchievement;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TAchievementDAOImpl extends BaseDaoImpl<TAchievement> implements TAchievementDAO {
    private static final Logger log = LoggerFactory
            .getLogger(TAchievementDAO1.class);
    // property constants
    public static final String ACHIEVEMENT_INTRODUCTION = "achievementIntroduction";
    public static final String ACHIEVEMENT_OWNER = "achievementOwner";
    public static final String ACHIEVEMENT_NAME = "achievementName";
    public static final String ACHIEVEMENT_JOURNAL = "achievementJournal";
    public static final String ACHIEVEMENT_VOLUME = "achievementVolume";
    public static final String ACHIEVEMENT_TYPE = "achievementType";
    public static final String ACHIEVEMENT_PATENT = "achievementPatent";
    public static final String ISDELETED = "isdeleted";
    public static final String USERDEFINE50 = "userdefine50";
    public static final String USERDEFINE49 = "userdefine49";
    public static final String USERDEFINE48 = "userdefine48";
    public static final String USERDEFINE47 = "userdefine47";
    public static final String USERDEFINE46 = "userdefine46";
    public static final String USERDEFINE45 = "userdefine45";
    public static final String USERDEFINE44 = "userdefine44";
    public static final String USERDEFINE43 = "userdefine43";
    public static final String USERDEFINE42 = "userdefine42";
    public static final String USERDEFINE41 = "userdefine41";
    public static final String USERDEFINE40 = "userdefine40";
    public static final String USERDEFINE39 = "userdefine39";
    public static final String USERDEFINE38 = "userdefine38";
    public static final String USERDEFINE37 = "userdefine37";
    public static final String USERDEFINE36 = "userdefine36";
    public static final String USERDEFINE35 = "userdefine35";
    public static final String USERDEFINE34 = "userdefine34";
    public static final String USERDEFINE33 = "userdefine33";
    public static final String USERDEFINE32 = "userdefine32";
    public static final String USERDEFINE31 = "userdefine31";
    public static final String USERDEFINE30 = "userdefine30";
    public static final String USERDEFINE29 = "userdefine29";
    public static final String USERDEFINE28 = "userdefine28";
    public static final String USERDEFINE27 = "userdefine27";
    public static final String USERDEFINE26 = "userdefine26";
    public static final String USERDEFINE25 = "userdefine25";
    public static final String USERDEFINE24 = "userdefine24";
    public static final String USERDEFINE23 = "userdefine23";
    public static final String USERDEFINE22 = "userdefine22";
    public static final String USERDEFINE21 = "userdefine21";
    public static final String USERDEFINE20 = "userdefine20";
    public static final String USERDEFINE19 = "userdefine19";
    public static final String USERDEFINE18 = "userdefine18";
    public static final String USERDEFINE17 = "userdefine17";
    public static final String USERDEFINE16 = "userdefine16";
    public static final String USERDEFINE15 = "userdefine15";
    public static final String USERDEFINE14 = "userdefine14";
    public static final String USERDEFINE13 = "userdefine13";
    public static final String USERDEFINE12 = "userdefine12";
    public static final String USERDEFINE11 = "userdefine11";
    public static final String USERDEFINE10 = "userdefine10";
    public static final String USERDEFINE9 = "userdefine9";
    public static final String USERDEFINE8 = "userdefine8";
    public static final String USERDEFINE7 = "userdefine7";
    public static final String USERDEFINE6 = "userdefine6";
    public static final String USERDEFINE5 = "userdefine5";
    public static final String USERDEFINE4 = "userdefine4";
    public static final String USERDEFINE3 = "userdefine3";
    public static final String USERDEFINE1 = "userdefine1";
    public static final String USERDEFINE2 = "userdefine2";


    @Override
    public List findByExample(TAchievement instance) {
 /*       log.debug("finding TAchievement instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: "
                    + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }*/

        return null;
    }

    @Override
    public List findByProperty(String propertyName, Object value) {
/*        log.debug("finding TAchievement instance with property: "
                + propertyName + ", value: " + value);
        try {
            String queryString = "from TAchievement as model where model."
                    + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }*/

        return null;
    }

    @Override
    public List findByAchievementIntroduction(Object achievementIntroduction) {
        return findByProperty(ACHIEVEMENT_INTRODUCTION, achievementIntroduction);
    }

    @Override
    public List findByAchievementOwner(Object achievementOwner) {
        return findByProperty(ACHIEVEMENT_OWNER, achievementOwner);
    }

    @Override
    public List findByAchievementName(Object achievementName) {
        return findByProperty(ACHIEVEMENT_NAME, achievementName);
    }

    @Override
    public List findByAchievementJournal(Object achievementJournal) {
        return findByProperty(ACHIEVEMENT_JOURNAL, achievementJournal);
    }

    @Override
    public List findByAchievementVolume(Object achievementVolume) {
        return findByProperty(ACHIEVEMENT_VOLUME, achievementVolume);
    }

    @Override
    public List findByAchievementType(Object achievementType) {
        return findByProperty(ACHIEVEMENT_TYPE, achievementType);
    }

    @Override
    public List findByAchievementPatent(Object achievementPatent) {
        return findByProperty(ACHIEVEMENT_PATENT, achievementPatent);
    }

    @Override
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }

    @Override
    public List findByUserdefine50(Object userdefine50) {
        return findByProperty(USERDEFINE50, userdefine50);
    }

    @Override
    public List findByUserdefine49(Object userdefine49) {
        return findByProperty(USERDEFINE49, userdefine49);
    }

    @Override
    public List findByUserdefine48(Object userdefine48) {
        return findByProperty(USERDEFINE48, userdefine48);
    }

    @Override
    public List findByUserdefine47(Object userdefine47) {
        return findByProperty(USERDEFINE47, userdefine47);
    }

    @Override
    public List findByUserdefine46(Object userdefine46) {
        return findByProperty(USERDEFINE46, userdefine46);
    }

    @Override
    public List findByUserdefine45(Object userdefine45) {
        return findByProperty(USERDEFINE45, userdefine45);
    }

    @Override
    public List findByUserdefine44(Object userdefine44) {
        return findByProperty(USERDEFINE44, userdefine44);
    }

    @Override
    public List findByUserdefine43(Object userdefine43) {
        return findByProperty(USERDEFINE43, userdefine43);
    }

    @Override
    public List findByUserdefine42(Object userdefine42) {
        return findByProperty(USERDEFINE42, userdefine42);
    }

    @Override
    public List findByUserdefine41(Object userdefine41) {
        return findByProperty(USERDEFINE41, userdefine41);
    }

    @Override
    public List findByUserdefine40(Object userdefine40) {
        return findByProperty(USERDEFINE40, userdefine40);
    }

    @Override
    public List findByUserdefine39(Object userdefine39) {
        return findByProperty(USERDEFINE39, userdefine39);
    }

    @Override
    public List findByUserdefine38(Object userdefine38) {
        return findByProperty(USERDEFINE38, userdefine38);
    }

    @Override
    public List findByUserdefine37(Object userdefine37) {
        return findByProperty(USERDEFINE37, userdefine37);
    }

    @Override
    public List findByUserdefine36(Object userdefine36) {
        return findByProperty(USERDEFINE36, userdefine36);
    }

    @Override
    public List findByUserdefine35(Object userdefine35) {
        return findByProperty(USERDEFINE35, userdefine35);
    }

    @Override
    public List findByUserdefine34(Object userdefine34) {
        return findByProperty(USERDEFINE34, userdefine34);
    }

    @Override
    public List findByUserdefine33(Object userdefine33) {
        return findByProperty(USERDEFINE33, userdefine33);
    }

    @Override
    public List findByUserdefine32(Object userdefine32) {
        return findByProperty(USERDEFINE32, userdefine32);
    }

    @Override
    public List findByUserdefine31(Object userdefine31) {
        return findByProperty(USERDEFINE31, userdefine31);
    }

    @Override
    public List findByUserdefine30(Object userdefine30) {
        return findByProperty(USERDEFINE30, userdefine30);
    }

    @Override
    public List findByUserdefine29(Object userdefine29) {
        return findByProperty(USERDEFINE29, userdefine29);
    }

    @Override
    public List findByUserdefine28(Object userdefine28) {
        return findByProperty(USERDEFINE28, userdefine28);
    }

    @Override
    public List findByUserdefine27(Object userdefine27) {
        return findByProperty(USERDEFINE27, userdefine27);
    }

    @Override
    public List findByUserdefine26(Object userdefine26) {
        return findByProperty(USERDEFINE26, userdefine26);
    }

    @Override
    public List findByUserdefine25(Object userdefine25) {
        return findByProperty(USERDEFINE25, userdefine25);
    }

    @Override
    public List findByUserdefine24(Object userdefine24) {
        return findByProperty(USERDEFINE24, userdefine24);
    }

    @Override
    public List findByUserdefine23(Object userdefine23) {
        return findByProperty(USERDEFINE23, userdefine23);
    }

    @Override
    public List findByUserdefine22(Object userdefine22) {
        return findByProperty(USERDEFINE22, userdefine22);
    }

    @Override
    public List findByUserdefine21(Object userdefine21) {
        return findByProperty(USERDEFINE21, userdefine21);
    }

    @Override
    public List findByUserdefine20(Object userdefine20) {
        return findByProperty(USERDEFINE20, userdefine20);
    }

    @Override
    public List findByUserdefine19(Object userdefine19) {
        return findByProperty(USERDEFINE19, userdefine19);
    }

    @Override
    public List findByUserdefine18(Object userdefine18) {
        return findByProperty(USERDEFINE18, userdefine18);
    }

    @Override
    public List findByUserdefine17(Object userdefine17) {
        return findByProperty(USERDEFINE17, userdefine17);
    }

    @Override
    public List findByUserdefine16(Object userdefine16) {
        return findByProperty(USERDEFINE16, userdefine16);
    }

    @Override
    public List findByUserdefine15(Object userdefine15) {
        return findByProperty(USERDEFINE15, userdefine15);
    }

    @Override
    public List findByUserdefine14(Object userdefine14) {
        return findByProperty(USERDEFINE14, userdefine14);
    }

    @Override
    public List findByUserdefine13(Object userdefine13) {
        return findByProperty(USERDEFINE13, userdefine13);
    }

    @Override
    public List findByUserdefine12(Object userdefine12) {
        return findByProperty(USERDEFINE12, userdefine12);
    }

    @Override
    public List findByUserdefine11(Object userdefine11) {
        return findByProperty(USERDEFINE11, userdefine11);
    }

    @Override
    public List findByUserdefine10(Object userdefine10) {
        return findByProperty(USERDEFINE10, userdefine10);
    }

    @Override
    public List findByUserdefine9(Object userdefine9) {
        return findByProperty(USERDEFINE9, userdefine9);
    }

    @Override
    public List findByUserdefine8(Object userdefine8) {
        return findByProperty(USERDEFINE8, userdefine8);
    }

    @Override
    public List findByUserdefine7(Object userdefine7) {
        return findByProperty(USERDEFINE7, userdefine7);
    }

    @Override
    public List findByUserdefine6(Object userdefine6) {
        return findByProperty(USERDEFINE6, userdefine6);
    }

    @Override
    public List findByUserdefine5(Object userdefine5) {
        return findByProperty(USERDEFINE5, userdefine5);
    }

    @Override
    public List findByUserdefine4(Object userdefine4) {
        return findByProperty(USERDEFINE4, userdefine4);
    }

    @Override
    public List findByUserdefine3(Object userdefine3) {
        return findByProperty(USERDEFINE3, userdefine3);
    }

    @Override
    public List findByUserdefine1(Object userdefine1) {
        return findByProperty(USERDEFINE1, userdefine1);
    }

    @Override
    public List findByUserdefine2(Object userdefine2) {
        return findByProperty(USERDEFINE2, userdefine2);
    }



    @Override
    public TAchievement merge(TAchievement detachedInstance) {
    /*    log.debug("merging TAchievement instance");
        try {
            TAchievement result = (TAchievement) getHibernateTemplate().merge(
                    detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }*/

        return null;
    }

    @Override
    public void attachDirty(TAchievement instance) {
   /*     log.debug("attaching dirty TAchievement instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }*/

    }

    @Override
    public void attachClean(TAchievement instance) {
 /*       log.debug("attaching clean TAchievement instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }*/

    }

    public static TAchievementDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TAchievementDAO) ctx.getBean("TAchievementDAO");
    }
}
