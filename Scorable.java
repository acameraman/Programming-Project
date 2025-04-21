/**
 * This interface includes a method to get the user's score
*/
interface Scorable
{
    /**
     * Gets score
     * @param answer the user's answer
     * @return the score as an integer
    */
    int getScore(String answer);
}