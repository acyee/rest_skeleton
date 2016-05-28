package demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anthony on 5/21/16.
 */
@Repository
public interface DemoRepository extends MongoRepository<Demo, String> {

        public List<Demo> findByText(String text);

}
