package study.funzin.main5;

import com.mongodb.*;

/**
 * Created by JE on 2017-05-02.
 */
public class SimpleMongo {

    MongoClient mongoClient = null;
    DB db = null;

    public void mongoTest(String ip, int port, String dbName) throws Exception{

        mongoClient = new MongoClient(new ServerAddress(ip, port));
        db = mongoClient.getDB(dbName);

        DBCollection userTable = db.getCollection("userTable");
        BasicDBObject doc = new BasicDBObject("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("info", new BasicDBObject("x", 203).append("y", 102));
        userTable.insert(doc);

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("count", 1);

        DBCursor cursor = userTable.find(searchQuery);

        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }

        System.out.println("Done");

    }

    public static void main(String args[]) throws Exception{

        SimpleMongo testRunner = new SimpleMongo();
        testRunner.mongoTest("localhost", 27017, "testdb");

    }

}
