/*
Cosine similarity is a measure of similarity between two vectors of an inner product space that measures the cosine of the angle between them. The cosine of 0° is 1, and it is less than 1 for any other angle.

See wiki: Cosine Similarity

Here is the formula:

/media/problem/cosine-similarity.png

Given two vectors A and B with the same size, calculate the cosine similarity.

Return 2.0000 if cosine similarity is invalid (for example A = [0] and B = [0]).

Have you met this question in a real interview? Yes
Example
Given A = [1, 2, 3], B = [2, 3 ,4].

Return 0.9926.

Given A = [0], B = [0].

Return 2.0000
*/

class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        
        if(A==null || A.length==0 || B==null || B.length==0){
            return 2.0;
        }
        int aSq = 0;
        int bSq = 0;
        int aTb = 0;
        
        for(int i=0; i<A.length; i++){
            aTb+= A[i]*B[i];
            aSq+=square(A[i]);
            bSq+=square(B[i]);
        }
        if(aSq==0 || bSq==0){
            return 2.0;
        }
        
        return aTb/(Math.sqrt((double)aSq) * Math.sqrt((double)bSq));
    }
    public int square(int num){
        return num*num;
    }
}

