    package com.WebtecFinalProject.Controller;

    import com.WebtecFinalProject.Model.Gun;
    import com.WebtecFinalProject.Model.Request;
    import com.WebtecFinalProject.Model.Returns;
    import com.WebtecFinalProject.Model.Soldier;
    import com.WebtecFinalProject.Service.GunService;
    import com.WebtecFinalProject.Service.RequestService;
    import com.WebtecFinalProject.Service.ReturnsService;
    import com.WebtecFinalProject.Service.SoldierService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.cache.annotation.Cacheable;
    import org.springframework.dao.DataIntegrityViolationException;
    import org.springframework.data.domain.Page;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.sql.SQLIntegrityConstraintViolationException;
    import java.util.List;
    import java.util.Optional;
    import java.util.UUID;

    @Controller
    public class ReportController {
        @Autowired
        SoldierService soldierService;
        @Autowired
        RequestService requestService;
        @Autowired
        ReturnsService returnsService;
        @Autowired
        GunService gunService;

        @CrossOrigin
        @GetMapping("/report")
        public String report(@RequestParam(name = "page", defaultValue = "0") int currentPage,
                             @RequestParam(name = "size", defaultValue = "10") int size, Model model) {
            model.addAttribute("soldierModel", new Soldier());

            // Soldiers
            Page<Soldier> soldiersPage = soldierService.getAllSoldiersPageable(currentPage, size);
            model.addAttribute("allSoldiers", soldiersPage.getContent());
            model.addAttribute("currentPageSoldiers", currentPage);
            model.addAttribute("totalPagesSoldiers", soldiersPage.getTotalPages());
            model.addAttribute("totalItemsSoldiers", soldiersPage.getTotalElements());

            // Requests
            Page<Request> requestsPage = requestService.getAllRequestsPageable(currentPage, size);
            model.addAttribute("allRequests", requestsPage.getContent());
            model.addAttribute("currentPageRequests", currentPage);
            model.addAttribute("totalPagesRequests", requestsPage.getTotalPages());
            model.addAttribute("totalItemsRequests", requestsPage.getTotalElements());

            // Guns
            Page<Gun> gunsPage = gunService.getAllGunsPageable(currentPage, size);
            model.addAttribute("allGuns", gunsPage.getContent());
            model.addAttribute("currentPageGuns", currentPage);
            model.addAttribute("totalPagesGuns", gunsPage.getTotalPages());
            model.addAttribute("totalItemsGuns", gunsPage.getTotalElements());

            // Returns
            Page<Returns> returnsPage = returnsService.getAllReturnsPageable(currentPage, size);
            model.addAttribute("allReturns", returnsPage.getContent());
            model.addAttribute("currentPageReturns", currentPage);
            model.addAttribute("totalPagesReturns", returnsPage.getTotalPages());
            model.addAttribute("totalItemsReturns", returnsPage.getTotalElements());

            // other model attributes...
            model.addAttribute("size", size);

            return "View";
        }


        @GetMapping("/report/delete-soldier/{id}")
        public String deleteSoldier(@PathVariable("id") UUID id, Model model) {
            try {
                soldierService.deleteSoldier(id);
                return "redirect:/report";
            } catch (DataIntegrityViolationException e) {
                // Log the exception if needed
                e.printStackTrace();

                // Add custom error message to the model
                model.addAttribute("errorMessage", "Cannot delete soldier due to existing dependencies.");

                // Return the error view
                return "error"; // Create an "error.html" Thymeleaf template for displaying error messages
            }
        }

        @GetMapping("/report/delete-request/{id}")
        public String deleteRequest(@PathVariable("id") UUID id, Model model){
            try {
                requestService.deleteReturn(id);
            } catch (Exception e) {
                // Handle the exception (check if it's a foreign key constraint violation)
                if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
                    String errorMessage = "Cannot delete request due to existing dependencies.";
                    model.addAttribute("errorMessage", errorMessage);
                } else {
                    // Handle other exceptions if needed
                }
            }
            return "redirect:/report";
        }
        @GetMapping("/report/delete-return/{id}")
        public String deleteReturns(@PathVariable("id") UUID id, Model model){
            try {
                returnsService.deleteReturns(id);
            } catch (Exception e) {
                // Handle the exception (check if it's a foreign key constraint violation)
                if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
                    String errorMessage = "Cannot delete return due to existing dependencies.";
                    model.addAttribute("errorMessage", errorMessage);
                } else {
                    // Handle other exceptions if needed
                }
            }
            return "redirect:/report";
        }
        @GetMapping("/report/delete-gun/{id}")
        public String deleteGun(@PathVariable("id") UUID id, Model model){
            try {
                gunService.deleteGun(id);
            } catch (Exception e) {
                // Handle the exception (check if it's a foreign key constraint violation)
                if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
                    String errorMessage = "Cannot delete gun due to existing dependencies.";
                    model.addAttribute("errorMessage", errorMessage);

                } else {
                    // Handle other exceptions if needed
                }
            }
            return "redirect:/report";
        }
    }
