package com.knowledgecenter.resumeportal;

import java.time.LocalDate;

import java.util.Optional;

import com.knowledgecenter.resumeportal.models.Education;
import com.knowledgecenter.resumeportal.models.Job;
import com.knowledgecenter.resumeportal.models.UserProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    UserProfileRepository userProfileRepository;

    @GetMapping("/")
    public String sayHello() {
        Optional<UserProfile> profileOptional = userProfileRepository.findByUserName("Lakshmi");
        profileOptional.orElseThrow(() -> new RuntimeException("User Not found"));
        UserProfile prof1 = profileOptional.get();

        Job job1 = new Job();
        job1.setCompany("TeqTron");
        job1.setDesignation("Software Engineer III");
        job1.setId(1);
        job1.setStartDate(LocalDate.of(2020,1,1));
        job1.setEndDate(LocalDate.of(2020,3,1));
        job1.setCurrentJob(true);
        job1.getResponsibilities().add("Analysis");
        job1.getResponsibilities().add("Coding");
        job1.getResponsibilities().add("Design");
        job1.getResponsibilities().add("Testing");

        Job job2 = new Job();
        job2.setCompany("Walmart Labs");
        job2.setDesignation("Software Engineer II");
        job2.setId(2);
        job2.setStartDate(LocalDate.of(2019,1,1));
        job2.setEndDate(LocalDate.of(2020,1,1));
        job2.getResponsibilities().add("Requirements Gathering");
        job2.getResponsibilities().add("High level design");

        Job job3 = new Job();
        job3.setCompany("Infosys");
        job3.setDesignation("Software Engineer I");
        job3.setId(3);
        job3.setStartDate(LocalDate.of(2004,9,20));
        job3.setEndDate(LocalDate.of(2010,4,1));
        job3.getResponsibilities().add("Unit Testing");
        job3.getResponsibilities().add("Integration Testing");

        prof1.getJobs().clear();
        prof1.getJobs().add(job1);
        prof1.getJobs().add(job2);
        prof1.getJobs().add(job3);

        Education education1 = new Education();
        education1.setCollege("University of Madras");
        education1.setDegree("B.Tech");
        education1.setSummary("4 years in Information Technology");
        education1.setStartDate(LocalDate.of(2000,6, 12));
        education1.setEndDate(LocalDate.of(2004, 5, 23));

        Education education2 = new Education();
        education2.setCollege("MIT");
        education2.setDegree("M.Tech");
        education2.setSummary("2 years in Information Technology");
        education2.setStartDate(LocalDate.of(2004,6, 12));
        education2.setEndDate(LocalDate.of(2006, 5, 23));

        prof1.getEducations().clear();
        prof1.getEducations().add(education1);
        prof1.getEducations().add(education2);

        prof1.getSkills().clear();
        prof1.getSkills().add("Java");
        prof1.getSkills().add("REST");
        prof1.getSkills().add("Spring");
        prof1.getSkills().add("SQL");

        userProfileRepository.save(prof1);

        return "profile";
    }

    @GetMapping("/edit")
    public String edit() {
        return "Edit Page!!";
    }

    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model) {
        Optional<UserProfile> userOptionalProfile = userProfileRepository.findByUserName(userId);
        userOptionalProfile.orElseThrow(() -> new RuntimeException("User Not found: "+userId));


        model.addAttribute("userId", userId);
        UserProfile userProfile = userOptionalProfile.get();
        model.addAttribute("userProfile", userProfile);
        System.out.println(userProfile.getJobs());
        return "profile-templates/"+ userProfile.getTheme()+ "/index";
    }
}