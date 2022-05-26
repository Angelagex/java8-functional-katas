package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream().flatMap( ml -> ml.getVideos().stream()
                        .map(m -> Map.of("id", m.getId(), "title", m.getTitle(), "url", m.getBoxarts().stream().reduce( (b1 , b2) -> b1.getWidth()*b1.getHeight() < b2.getWidth() * b2.getHeight() ? b1 : b2).get().getUrl())))
                .collect(Collectors.toList());
    }
}
