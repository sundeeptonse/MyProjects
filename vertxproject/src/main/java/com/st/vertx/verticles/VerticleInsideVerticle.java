/**
 * 
 */
package com.st.vertx.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * @author sundeeptonse
 * Creating a Verticle
 * The Vertx instance by itself doesn't do much except all the thread management, 
 * creating an event bus etc. which are all communication and infrastructure tasks. 
 * In order to get the application to do something useful, 
 * you need to deploy one or more verticles (component) inside the Vertx instance.
 * Before you can deploy a verticle you need to create it. 
 * You do so by creating a class that extends AbstractVerticle. Here is a verticle example:
 */
public class VerticleInsideVerticle extends AbstractVerticle {

	@Override
	public void start(Future<Void> startFuture) {
		System.out.println("VerticleInsideVerticle started!");
		vertx.deployVerticle(new VerticleInsideVerticle2());
	}

	@Override
	public void stop(Future stopFuture) throws Exception {
		System.out.println("VerticleInsideVerticle stopped!");
	}

}
