package katas;

import model.Movie;
import util.DataUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        return movies.stream().map( m -> m.getBoxarts()).map(ba -> ba.stream().reduce((box1, box2) -> box1.getHeight()* box1.getWidth() > box2.getHeight()*box2.getWidth() ? box1 : box2)).map(
                b -> b.get().getUrl()).collect(Collectors.toList()).get(3);
    }
}
