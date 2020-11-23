package edu.upc.dsa.services;


import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;

@Api(value = "/usuaris", description = "Endpoint to Usuaris Service")
@Path("/usuaris")
public class UsuarioService {

    private Covid19Manager tm;

    public UsuarioService() {
        this.tm = Covid19ManagerImpl.getInstance();
        if (tm.size()==0) {                   //ho posa el doble de vegades =?=?
            this.tm.addUsuario("21","juan","garcia","12/12","D");
            this.tm.addUsuario("32","jose","garcia","2/12","A");
        }
    }

    @GET
    @ApiOperation(value = "Get Usuarios", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {

        Collection<Usuario> brotes = this.tm.brotesDisp();
        GenericEntity<Collection<Brote>> brot = new GenericEntity<Collection<Brote>>(brotes) {};
        return Response.status(201).entity(brot).build()  ;

    }

    @GET
    @ApiOperation(value = "get an Album", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Album.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlbum(@PathParam("id") String id) {
        Album a = this.tm.getAlbum(id);
        if (a == null) return Response.status(404).build();
        else  return Response.status(201).entity(a).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Album", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteAlbum(@PathParam("id") String id) {
        Album a = this.tm.getAlbum(id);
        if (a == null) return Response.status(404).build();
        else this.tm.deleteAlbum(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update an Album", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateAlbum(Album album) {

        Album a = this.tm.updateAlbum(album);

        if (a == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Album", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Album.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newAlbum(Album album) {

        if (album.getSinger()==null || album.getTitle()==null)  return Response.status(500).entity(album).build();
        this.tm.addAlbum(album);
        return Response.status(201).entity(album).build();
    }

}
