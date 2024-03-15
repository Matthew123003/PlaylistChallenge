package io.zipcoder;

public class Music {

    private String[] playList;

    private Integer startIndex;

    private String selection;



    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection){
        return Integer.min(nextSong(startIndex, selection), prevSong(startIndex, selection));
    }

    public Integer nextSong(int start, String sel){
        int numJumps = 0;
        for (int i = start; i < playList.length ; i++) {
            if (playList[i].equals(sel)){
                return numJumps;
            }
            numJumps++;
        }
        numJumps++;
        for (int i = 0; i < start; i++) {
            if(playList[i].equals(sel)){
                return numJumps;
            }
            numJumps++;
        }
        return null;
    }

    public Integer prevSong(int start, String sel){
        int numJumps = 0;
        for (int i = start; i >= 0 ; i--) {
            if (playList[i].equals(sel)){
                return numJumps;
            }
            if (start == 0) {
                break;
            }
            numJumps++;
        }
        numJumps++;
        for (int i = playList.length - 1; i > start; i--) {
            if(playList[i].equals(sel)){
                return numJumps;
            }
            numJumps++;
        }
        return null;
    }
}
