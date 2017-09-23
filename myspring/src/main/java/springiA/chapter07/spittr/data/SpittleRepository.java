package springiA.chapter07.spittr.data;

import java.util.List;

import springiA.chapter07.spittr.Spittle;


public interface SpittleRepository {

  List<Spittle> findRecentSpittles();

  List<Spittle> findSpittles(long max, int count);
  
  Spittle findOne(long id);

  void save(Spittle spittle);

}
