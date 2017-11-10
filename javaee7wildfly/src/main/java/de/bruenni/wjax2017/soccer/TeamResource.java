package de.bruenni.wjax2017.soccer;

import de.bruenni.wjax2017.soccer.dto.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/")
@RequestScoped
public class TeamResource {

/*    @Inject
    private SoccerService soccer;*/

    public TeamResource() {
    }

    @GET
    @Path("/test")
    public String getTest() {
        return "test";
    }

    @GET
    @Path("/teams")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray getTeams() {
        return Json.createArrayBuilder().add(Json.createObjectBuilder().add("key", "value1")).build();
    }

    @GET
    @Path("/teamsPojo")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Team> getTeamsWithPojo() {
        return Arrays.asList(new Team());
    }

    @POST
    @Path("/teams")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response postTeam(@QueryParam("name") String teamName) {
        return javax.ws.rs.core.Response.ok().entity(new Team()).build();
    }
}
