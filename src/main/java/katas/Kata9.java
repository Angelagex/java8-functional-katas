package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream().flatMap( ml -> ml.getVideos().stream()
                        .map(m -> Map.of("id", m.getId(), "title", m.getTitle(), "interestingMoment", m.getInterestingMoments().stream().map( moment -> moment.getType()=="Middle"? moment.getTime() : "").collect(Collectors.toList()).get(1), "url", m.getBoxarts().stream().reduce( (b1 , b2) -> b1.getWidth()*b1.getHeight() < b2.getWidth() * b2.getHeight() ? b1 : b2).get().getUrl())))
                .collect(Collectors.toList());
    }
}
