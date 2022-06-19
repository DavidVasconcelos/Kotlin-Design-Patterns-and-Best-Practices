import io.vertx.core.Vertx
import io.vertx.pgclient.PgConnectOptions
import io.vertx.pgclient.PgPool
import io.vertx.sqlclient.PoolOptions
import io.vertx.sqlclient.SqlClient


object Db {
    val username = System.getenv("POSTGRES_USER") ?: "cats_admin"
    val password = System.getenv("POSTGRES_PASSWORD") ?: "abcd1234"
    val database = System.getenv("POSTGRES_DB_NAME") ?: "cats_db"
    val host = System.getenv("POSTGRES_HOST") ?: "localhost"

fun connect(vertx: Vertx): SqlClient {
    val connectOptions = PgConnectOptions()
        .setPort(5432)
        .setHost(host)
        .setDatabase(database)
        .setUser(username)
        .setPassword(password)

    val poolOptions = PoolOptions()
        .setMaxSize(20)

    return PgPool.client(
        vertx,
        connectOptions,
        poolOptions
    )
}
}
