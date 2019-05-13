/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

/**
 *
 * @author becky
 */
public class Edge {
    private String sourceNode;
    private String targetNode;
    
    Edge(String inputSource, String inputTarget)
    {
        this.sourceNode = inputSource;
        this.targetNode = inputTarget;
        
    }
}
