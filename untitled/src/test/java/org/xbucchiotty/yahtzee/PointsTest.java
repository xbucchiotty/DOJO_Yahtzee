package org.xbucchiotty.yahtzee;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 19:02
 */
public class PointsTest {
    
    @Test
    public void should_set_first_result(){
        Points points = new Points();
        assertThat(points.getPoints()).isEqualTo(0);
        
        points.setPoints(10);
        assertThat(points.getPoints()).isEqualTo(10);
    }    
    @Test
    public void should_not_set_second_result(){
        Points points = new Points();
        assertThat(points.getPoints()).isEqualTo(0);
        
        points.setPoints(10);
        points.setPoints(20);
        
        assertThat(points.getPoints()).isEqualTo(10);
    }
}
