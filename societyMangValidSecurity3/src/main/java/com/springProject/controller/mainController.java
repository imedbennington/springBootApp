package com.springProject.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springProject.DTO.ProductDto;
import com.springProject.DTO.UserDTO;
import com.springProject.entity.Employee;
import com.springProject.entity.Product;
import com.springProject.entity.User;
import com.springProject.service.InterfaceEmployee;
import com.springProject.service.InterfaceProduct;
import com.springProject.service.InterfaceUser;
import com.springProject.service.ProductService;
import com.springProject.service.UserService;

@Controller
//@RequestMapping("/app/")
public class mainController {
	private UserService userService;
	private String UploadDirectory=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\photos";
	@Autowired
	InterfaceProduct prodService;
	@Autowired
	InterfaceEmployee employeeService;
	@Autowired
	InterfaceUser user_service;
	public mainController(UserService userService, ProductService prodService) {
        this.userService = userService;
        this.prodService=prodService;
    }
	// handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }
 // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDTO userDto,
                               BindingResult result,
                               Model model){
       User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
 // handler method to handle list of users
    @GetMapping("/viewusers")
    public String users(Model model){
        List<UserDTO> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
 // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    //return create product page 
    @GetMapping("/create_prod")
    public String getPage(Model m) {
    	Product prod = new Product();
    	m.addAttribute("prod", prod);
    	return"CreateProduct";
    }
    @PostMapping("/create_prod/save")
    public String SaveProd(@Valid @ModelAttribute("prod") Product prod, Model m, BindingResult result, @RequestParam("file") MultipartFile multipartFile) {
    	 if(result.hasErrors()){
             m.addAttribute("prod", prod);
             return "/create_prod";
         } 
    	else {
    		String fileName=multipartFile.getOriginalFilename();
    		Path fileNameAndPath=Paths.get(UploadDirectory, fileName);
    		try {
    			Files.write(fileNameAndPath,multipartFile.getBytes());
    		}catch(IOException e) {
    			e.printStackTrace();
    			}
    		prod.setPhoto(fileName);
             m.addAttribute("successMsg", "Details saved successfully!!");
             m.addAttribute("productlist",prodService.getAllproduct());
             prodService.AddProduct(prod);
             return "redirect:/view";
    }
}
    @GetMapping("/update_user/{id}")
    public String Updateuser (Model m, @PathVariable Long id) {
    	m.addAttribute("user",user_service.getUserByid(id));
    	return"Update_user";
    }
    @PostMapping("/update_user")
    public String updateuser(User user) {
    	userService.updateUser(user);
    	return"redirect:/viewusers";
    }
    @GetMapping("/view")
    public String ViewProd (Model m) {
    	 m.addAttribute("productlist",prodService.getAllproduct());
    	return"success";
    }
    @GetMapping("/view_employee")
    public String ViewEmpl (Model m) {
    	 m.addAttribute("employeeList",employeeService.getAllEmployees());
    	return"View_employee";
    }
    
    @GetMapping("/update_prod/{id}")
    public String Update (Model m, @PathVariable Long id) {
    	//m.addAttribute("product",prodService.GetProductById(id));
    	m.addAttribute("product", prodService.GetProductById(id));
    	return"UpdateProduct";
    }
    @PostMapping("/update")
    public String update(Product prod) {
    	prodService.updateProd(prod);
    	return"redirect:/view";
    }
    @GetMapping("/delete/{id}")
    public String Delete (@PathVariable Long id) {
    	prodService.DeleteProd(id);
    	return "redirect:/view";
    }
    @GetMapping("/addemp")
    public String AddEmpl (Model m) {
    	Employee emp = new Employee();
    	m.addAttribute("employee", emp);
    	return"Create_Employee";
    }
    @PostMapping("/addemp/save")
    public String SaveEmployee(@Valid @ModelAttribute("employee") Employee emp, BindingResult result, Model m) {
    	 if(result.hasErrors()){
             m.addAttribute("employee", emp);
             return "/addemp";
         } 
    	else {
             m.addAttribute("successMsg", "Details saved successfully!!");
             m.addAttribute("employeeList",prodService.getAllproduct());
             employeeService.AddEmployee(emp);
             return "redirect:/view_employee";
    }
    }
    @GetMapping("/update_emp/{id}")
    public String UpdateEmp (Model m, @PathVariable Long id) {
    	//m.addAttribute("product",prodService.GetProductById(id));
    	m.addAttribute("employee", employeeService.GetEmpById(id));
    	return"Update_Employee";
    }
    @PostMapping("/update_emp")
    public String updateEmplo(Employee emp) {
    	employeeService.UpdateEmployee(emp);
    	return"redirect:/view_employee";
    }
    @PostMapping("/findprodname")
    public String findByName(@RequestParam String key, Model m) {
    	m.addAttribute("productlist", prodService.getProductByName(key));
    	return"success";
    }
    @PostMapping("/findempname")
    public String findempByName(@RequestParam String key, Model m) {
    	m.addAttribute("employeeList", employeeService.getEmployeeByName(key));
    	return"View_employee";
    }
    @GetMapping("delete_emp/{id}")
    public String DeleteEmpl(@PathVariable Long id) {
    	employeeService.DeleteEmployee(id);
    	return"redirect:/view_employee";
    }
}
