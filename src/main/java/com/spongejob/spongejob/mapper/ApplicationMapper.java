package com.spongejob.spongejob.mapper;

import com.spongejob.spongejob.dto.ApplicationDTO;
import com.spongejob.spongejob.dto.ApplicationWithEmpInfoDTO;
import com.spongejob.spongejob.dto.ApplicationWithJPInfoDTO;
import com.spongejob.spongejob.model.Application;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationMapper {

    public ApplicationDTO maptoDto(Application application) {
        if (application == null) {
            return null;
        }

        ApplicationDTO applicationDTO = new ApplicationDTO();

        applicationDTO.setApplicationId(application.getApplicationId());
        applicationDTO.setAnswer(application.getAnswer());
        applicationDTO.setApplicationDate(application.getApplicationDate());

        return applicationDTO;
    }

    public List<ApplicationDTO> maptoDto(List<Application> applications) {
        if ( applications == null ) {
            return null;
        }

        List<ApplicationDTO> list = new ArrayList<>();
        for ( Application application : applications ) {
            list.add( maptoDto( application ) );
        }

        return list;
    }

    public Application maptoEntity(ApplicationDTO applicationDTO) {
        if (applicationDTO == null) {
            return null;
        }

        Application application = new Application();

        application.setAnswer(applicationDTO.getAnswer());
        application.setApplicationDate(applicationDTO.getApplicationDate());


        return application;
    }

    public List<Application> maptoEntity(List<ApplicationDTO> applicationDTOS) {
        if ( applicationDTOS == null ) {
            return null;
        }

        List<Application> list = new ArrayList<>();
        for ( ApplicationDTO applicationDTO : applicationDTOS ) {
            list.add( maptoEntity( applicationDTO ) );
        }

        return list;
    }

    public ApplicationWithEmpInfoDTO maptoEmpInfoDto(Application application) {
        if (application == null) {
            return null;
        }

        ApplicationWithEmpInfoDTO applicationWithEmpInfoDTO = new ApplicationWithEmpInfoDTO();

        applicationWithEmpInfoDTO.setAnswer(application.getAnswer());
        applicationWithEmpInfoDTO.setApplicationDate(application.getApplicationDate());
        applicationWithEmpInfoDTO.setFirstname(application.getApplicant().getFirstname());
        applicationWithEmpInfoDTO.setSurname(application.getApplicant().getSurname());
        applicationWithEmpInfoDTO.setPhone(application.getApplicant().getPhone());
        applicationWithEmpInfoDTO.setEmail(application.getApplicant().getEmail());
        applicationWithEmpInfoDTO.setAge(application.getApplicant().getAge());
        applicationWithEmpInfoDTO.setCv(application.getApplicant().getCv());

        return applicationWithEmpInfoDTO;
    }

    public List<ApplicationWithEmpInfoDTO> maptoEmpInfoDto(List<Application> applications) {
        if ( applications == null ) {
            return null;
        }

        List<ApplicationWithEmpInfoDTO> list = new ArrayList<>();
        for ( Application application : applications ) {
            list.add( maptoEmpInfoDto( application ) );
        }

        return list;
    }

    public ApplicationWithJPInfoDTO maptoJPInfoDto(Application application) {
        if (application == null) {
            return null;
        }

        ApplicationWithJPInfoDTO applicationWithJPInfoDTO = new ApplicationWithJPInfoDTO();

        applicationWithJPInfoDTO.setAnswer(application.getAnswer());
        applicationWithJPInfoDTO.setApplicationDate(application.getApplicationDate());
        applicationWithJPInfoDTO.setJobName(application.getJobPost().getJobName());
        applicationWithJPInfoDTO.setCompanyName(application.getJobPost().getCompany().getName());
        applicationWithJPInfoDTO.setType(application.getJobPost().getType());
        applicationWithJPInfoDTO.setSalary(application.getJobPost().getSalary());
        applicationWithJPInfoDTO.setAddress(application.getJobPost().getAddress());
        applicationWithJPInfoDTO.setPosition(application.getJobPost().getPosition());
        applicationWithJPInfoDTO.setExpectation(application.getJobPost().getExpectation());
        applicationWithJPInfoDTO.setApplicantCount(application.getJobPost().getApplicantCount());
        applicationWithJPInfoDTO.setStartDate(application.getJobPost().getStartDate());
        applicationWithJPInfoDTO.setEndDate(application.getJobPost().getEndDate());
        applicationWithJPInfoDTO.setEvaluationDate(application.getJobPost().getEvaluationDate());

        return applicationWithJPInfoDTO;
    }

    public List<ApplicationWithJPInfoDTO> maptoJPInfoDto(List<Application> applications) {
        if ( applications == null ) {
            return null;
        }

        List<ApplicationWithJPInfoDTO> list = new ArrayList<>();
        for ( Application application : applications ) {
            list.add( maptoJPInfoDto( application ) );
        }

        return list;
    }
}