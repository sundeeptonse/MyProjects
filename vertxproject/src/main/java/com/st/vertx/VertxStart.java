/**
 * 
 */
package com.st.vertx;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

import com.st.vertx.verticles.BasicVerticle;
import com.st.vertx.verticles.MyVerticle;
import com.st.vertx.verticles.VerticleInsideVerticle;

/**
 * @author sundeeptonse
 *
 */
public class VertxStart {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {

		/*-
		 * The first step to using Vert.x embedded in your own Java application is to create a Vertx instance. 
		 * Here is how you create a Vertx instance:
		 * 
		 * You create a Vertx instance by calling Vertx.vertx().
		 * 
		 * The Vertx instance creates a number of threads internally to handle the exchange of messages between verticles. 
		 * These threads are not daemon threads, 
		 * so they prevent the JVM from shutting down, 
		 * even if the main thread creating the Vertx instance terminates.
		 * */
		Vertx vertx = Vertx.vertx();

		/*
		 * Deploying a Verticle Once you have created a verticle you need to
		 * deploy it to the Vertx instance. You deploy a verticle using one of
		 * the deployVerticle() methods on the Vertx instance. Here is a Vert.x
		 * verticle deployment example:
		 */

		vertx.deployVerticle(new MyVerticle());

		// or
		// vertx.deployVerticle("com.st.vertx.verticles.MyVerticle");

		/*
		 * The verticle will be deployed asynchronously, so the verticle may not
		 * be deployed by the time the deployVerticle() method returns. If you
		 * need to know exactly when a verticle is fully deployed, you can
		 * provide a Handler implementation to the the deployVerticle(). Here is
		 * how that looks:
		 */

		// vertx.deployVerticle(new BasicVerticle(),
		// new Handler<AsyncResult<String>>() {
		// @Override
		// public void handle(AsyncResult<String> stringAsyncResult) {
		// System.out.println("BasicVerticle deployment complete");
		// }
		// });
		//
		// vertx.deployVerticle(new BasicVerticle(), stringAsyncResult ->
		// {
		// System.out.println("BasicVerticle deployment complete");
		// });

		
		vertx.deployVerticle(new VerticleInsideVerticle());
	}

}
