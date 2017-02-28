package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Produit;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class ProduitRestService {
	@Autowired
	private ProduitRepository produitRepository;

	@ApiOperation(value="getProducts",nickname="getProducts",produces="application/json")
	@RequestMapping(value="/produits",method=RequestMethod.GET)
	@ApiResponses(value={            
			@ApiResponse(code = 200, message = "Success", response = Produit.class,responseContainer="List"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	public List< Produit > listProduit(){
		return produitRepository.findAll();
	}
	
	@ApiOperation(value="getOneProduct",nickname="getOneProduct",produces="application/json")
	@RequestMapping(value="/produits/{id}",method=RequestMethod.GET)
	@ApiResponses(value={            
			@ApiResponse(code = 200, message = "Success", response = Produit.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	public Produit getProduit(@PathVariable ("id") Long id){
		return produitRepository.findOne(id);
	}
	@ApiOperation(value="postProduct",nickname="postProduct",produces="application/json")
	@RequestMapping(value="/produits",method=RequestMethod.POST)
	@ApiResponses(value={            
			@ApiResponse(code = 200, message = "Success", response = Produit.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	public Produit save(@RequestBody Produit p){
		return produitRepository.save(p);
	}

}
