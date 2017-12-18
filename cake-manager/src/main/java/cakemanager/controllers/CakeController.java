package cakemanager.controllers;


import cakemanager.domain.Cake;
import cakemanager.services.CakeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    private static final String CROSS_ORIGN_PATH = "http://localhost:8881";
    private static final String LIST_PATH = "/list";
    private static final String TYPE = "application/json";
    private static final String DELETE_PATH = "/delete/{id}";
    private static final String UPDATE_PATH = "/update/{id}";
    private static final String ADD_PATH = "/add";
    private static final String SHOW_PATH = "/show/{id}";
    private static final String VIEW_TEXT = "View a list of available cakes";
    private static final String SEARCH_TEXT = "Search a cake with an ID";
    private static final String ADD_TEXT = "Add a cake";
    private static final String UPDATE_TEXT = "Update a cake";
    private static final String DELETE_TEXT = "Delete a cake";

    @Setter
    @Autowired
    private CakeService cakeService;

    @ApiOperation(value = VIEW_TEXT, response = Iterable.class)
    @CrossOrigin(origins = CROSS_ORIGN_PATH)
    @RequestMapping(value = LIST_PATH, method = RequestMethod.GET, produces = TYPE)
    public Iterable<Cake> list(Model model) {
        Iterable<Cake> cakeList = cakeService.getAllCakes();
        return cakeList;
    }

    @ApiOperation(value = SEARCH_TEXT, response = Cake.class)
    @RequestMapping(value = SHOW_PATH, method = RequestMethod.GET, produces = TYPE)
    public Cake showCake(@PathVariable Integer id, Model model) {
        Cake cake = cakeService.getCakeById(Long.valueOf(id));
        return cake;
    }

    @ApiOperation(value = ADD_TEXT)
    @RequestMapping(value = ADD_PATH, method = RequestMethod.POST, produces = TYPE)
    public ResponseEntity saveCake(@RequestBody Cake cake) {
        cakeService.saveOrUpdate(cake);
        return new ResponseEntity(ADD_TEXT, HttpStatus.OK);
    }

    @ApiOperation(value = UPDATE_TEXT)
    @RequestMapping(value = UPDATE_PATH, method = RequestMethod.PUT, produces = TYPE)
    public ResponseEntity updateCake(@PathVariable Integer id, @RequestBody Cake cake) {
        Cake storedCake = cakeService.getCakeById(Long.valueOf(id));
        storedCake.setDescription(cake.getDescription());
        storedCake.setImageUrl(cake.getImageUrl());
        storedCake.setPrice(cake.getPrice());
        cakeService.saveOrUpdate(cake);
        return new ResponseEntity(UPDATE_TEXT, HttpStatus.OK);
    }

    @ApiOperation(value = DELETE_TEXT)
    @RequestMapping(value = DELETE_PATH, method = RequestMethod.DELETE, produces = TYPE)
    public ResponseEntity delete(@PathVariable Integer id) {
        cakeService.delete(Long.valueOf(id));
        return new ResponseEntity(DELETE_TEXT, HttpStatus.OK);

    }

}
