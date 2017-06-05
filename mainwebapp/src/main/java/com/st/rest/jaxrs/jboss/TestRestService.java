/**
 * 
 */
package com.st.rest.jaxrs.jboss;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * @author sundeeptonse
 *
 */

@Path("/message")
public class TestRestService {

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {
		String result = "Restful example : " + msg;
		return Response.status(200).entity(result).build();
	}

}
