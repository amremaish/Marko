/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marko.physics;

/**
 *
 * @author Amr
 */
public class vector {

    private float first, second;

    public vector mal(vector first, vector second) {
        vector mal = new vector();
        mal.setFirst(first.getFirst() * second.getFirst());
        mal.setSecond(first.getSecond() * second.getSecond());
        return mal;
    }

    public vector plus(vector first, vector second) {
        vector plus = new vector();
        plus.setFirst(first.getFirst() + second.getFirst());
        plus.setSecond(first.getSecond() + second.getSecond());
        return plus;
    }

    public float getFirst() {
        return first;
    }

    public void setFirst(float first) {
        this.first = first;
    }

    public float getSecond() {
        return second;
    }

    public void setSecond(float second) {
        this.second = second;
    }

}
