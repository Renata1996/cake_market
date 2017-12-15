package cakemanager.controllers;


import cakemanager.entities.Cake;
import cakemanager.services.CakeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cake")
@CrossOrigin(origins = "http://localhost:8881")
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class CakeController {


    @Setter
    @Autowired
    private CakeService cakeService;


    @ApiOperation(value = "View a list of available cakes", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @CrossOrigin(origins = "http://localhost:8881")
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Cake> list(Model model) {
        Iterable<Cake> cakeList = cakeService.getAllCakes();
        return cakeList;
    }

    @ApiOperation(value = "Search a cake with an ID", response = Cake.class)
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public Cake showCake(@PathVariable Integer id, Model model) {
        Cake cake = cakeService.getCakeById(Long.valueOf(id));
        return cake;
    }

    @ApiOperation(value = "Add a cake")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveCake(@RequestBody Cake cake) {
        cakeService.saveOrUpdate(cake);
        return new ResponseEntity("Cake saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update a cake")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateCake(@PathVariable Integer id, @RequestBody Cake cake) {
        Cake storedCake = cakeService.getCakeById(Long.valueOf(id));
        storedCake.setDescription(cake.getDescription());
        storedCake.setImageUrl(cake.getImageUrl());
        storedCake.setPrice(cake.getPrice());
        cakeService.saveOrUpdate(cake);
        return new ResponseEntity("Cake updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a cake")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable Integer id) {
        cakeService.delete(Long.valueOf(id));
        return new ResponseEntity("Cake deleted successfully", HttpStatus.OK);

    }

}
