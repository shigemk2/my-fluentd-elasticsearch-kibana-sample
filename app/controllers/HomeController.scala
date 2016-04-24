package controllers

import javax.inject._

import org.fluentd.logger.scala.FluentLoggerFactory
import play.api.mvc._

import scala.collection.mutable

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    val LOG = FluentLoggerFactory.getLogger("fluentd.test.access", "192.168.99.100", 24224)
    val data = new mutable.HashMap[String, String]();
    data.put("from", "userA");
    data.put("to", "userB");
    LOG.log("follow", data);
    Ok(views.html.index("Your new application is ready."))
  }

}
