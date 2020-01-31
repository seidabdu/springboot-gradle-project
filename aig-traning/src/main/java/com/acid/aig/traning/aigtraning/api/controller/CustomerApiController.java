package com.acid.aig.traning.aigtraning.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acid.aig.traning.aigtraning.model.Customer;
import com.acid.aig.traning.aigtraning.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/1.0")
@Api(value = "Customer Controller", description = "Operations pertaining to Users.")
public class CustomerApiController {

	@Autowired
    private  CustomerService customerService;

 

    /**
     *
     * @return
     */
    @ApiOperation(value = "Returns all list of users.", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/getAllCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllUsers() {

        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "Returns User if ID is found.", response = Customer.class)
    @GetMapping(value = "/Customers/{companyName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getUserById(@PathVariable("companyName")
                                               @ApiParam(value = "Company Name", required = true) String companyName) {

        return new ResponseEntity<>(customerService.findByCompanyName(companyName), HttpStatus.OK);
    }

//    /**
//     *
//     * @param user
//     * @return
//     */
//    @ApiOperation(value = "Stores the user.", response = User.class)
//    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<User> saveUser(
//            @ApiParam(value = "User details", required = true) @RequestBody User user) {
//
//        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
//    }
//
//    /**
//     *
//     * @param user
//     * @return
//     */
//    @ApiOperation(value = "Updates the user based Id.")
//    @PutMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<Void> updateUser(
//            @ApiParam(value = "User details", required = true) @RequestBody User user){
//
//        Long id = user.getId();
//        userService.updateUser(user, id);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    /**
//     *
//     * @param id
//     * @return
//     */
//    @ApiOperation(value = "Deletes the user based on given Id.")
//    @DeleteMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<Void> deleteUser(
//            @ApiParam(value = "User ID", required = true) @PathVariable("id") Long id){
//
//        userService.deleteUser(id);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}