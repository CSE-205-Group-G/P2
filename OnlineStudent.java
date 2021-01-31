//**************************************************************************************************
// CLASS: OnlineStudent
//
// DESCRIPTION
// OnlineStudent is a direct subclass of the abstract class Student. It overrides the method calcTuition
// and adds an instance variable called TechFee.
//
// GROUP: G
// AUTHOR 1: Addison Corey, tjcorey, addison.corey@asu.edu
// AUTHOR 2: Keatyn Garton, kgarton, kgarton@asu.edu
// AUTHOR 3: Jonathan Kilgore, jpkilgor, jpkilgor@asu.edu
//**************************************************************************************************
public class OnlineStudent extends Student {
    private boolean TechFee;

    /**
     * Student constructor that initializes the mId, mFirstName, and mLastName instance
     * variables.
     *
     * @param pId
     * @param pFirstName
     * @param pLastName
     */
    public OnlineStudent(String pId, String pFirstName, String pLastName) {
        super(pId, pFirstName, pLastName);
    }

    /**
     * Overrides calcTuition method from Student.
     */

    @Override
    public void calcTuition() {
        double t = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;
        if(getTechFee()){
            t = t + TuitionConstants.ONLINE_TECH_FEE;
        }
        setTuition(t);
    }

    /**
     * Accessor method for getTechFee
     */

    public boolean getTechFee() {
        return TechFee;
    }
    /**
     * Mutator method for getTechFee
     */

    public void setTechFee(boolean mTechFee) {
        this.TechFee = mTechFee;
    }
}
