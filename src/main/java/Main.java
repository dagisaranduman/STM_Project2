import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;


class Neo4j_Connection_Test implements AutoCloseable
{
    private final Driver driver;

    public Neo4j_Connection_Test(String uri, String user, String password )
    {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }

    @Override
    public void close() throws Exception
    {
        driver.close();
    }

    public static void main( String... args ) throws Exception
    {
        try ( Neo4j_Connection_Test greeter = new Neo4j_Connection_Test( "bolt://localhost:7687", "neo4j", "12345" ) )
        {
            System.out.println( "Connection Success" );
        }
    }
}