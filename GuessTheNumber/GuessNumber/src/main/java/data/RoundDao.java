package data;

import entity.Round;
import java.util.List;

public interface RoundDao {
    
    Round add(Round round);
    List<Round> getRoundbyGameid(int gameid);
}
