package learn.avinash.spring.boot.ppmtool.services;

import learn.avinash.spring.boot.ppmtool.domain.Project;
import learn.avinash.spring.boot.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        //Logic

        return projectRepository.save(project);
    }

}
