package webTools;

import Scheduler.Scheduler;
import dataLayer.dataMappers.ProjectMapper.BidMapper;
import dataLayer.dataMappers.SkillMapper.SkillMapper;
import model.Exceptions.DupEndorse;
import model.Repo.GetRepo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class Startup implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        GetRepo.print("Starting Startup ##################################");
        try {
            new SkillMapper();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(!GetRepo.isSetRepo) {
            try {
                GetRepo.setRepo();
                try {
                    new BidMapper();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (DupEndorse dupEndorse) {
                dupEndorse.printStackTrace();
            }
            Scheduler scheduler = new Scheduler();
        }
    }
}
