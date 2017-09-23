package springiA.chapter07.spittr.data;

import springiA.chapter07.spittr.Spitter;

public interface SpitterRepository {

  Spitter save(Spitter spitter);
  
  Spitter findByUsername(String username);

}
