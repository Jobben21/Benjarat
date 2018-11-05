package com.example.ben.example.Data;

import android.util.Log;

import com.example.ben.example.R;

public class Blood  {

    public void Blood(){

    }

    public String[] getName(){

        String[] name = {"Glucose","Sodium","Potassium","Cholesterol","LDL","HDL","Triglyceride"};

        return name;
    }

    public Integer[] getSeekbar() {

        Integer[] seekbar = {78,120,3,0,0,35,0};

        return seekbar;
    }

    public Integer[] getSecondarybar(){
        Integer[] progressbar = {110,136,5,200,130,100,150};

        return progressbar;
    }

    public Integer[] getProgressbar(){
        Integer[] progressbar = {110,136,5,200,130,100,150};

        return progressbar;
    }

    public Integer[] getSeekbarMax(){
        Integer[] seekbarMax = {200,200,8,400,300,100,500};

        return seekbarMax;
    }

    public Integer[] getProgressbarMax(){
        Integer[] progressbarMax = {200,200,8,400,300,100,500};

        return progressbarMax ;
    }

    public String[] getUnitBlood(){

        String[] unit = {"mg/dl","mmol/L","mEq/L","mg/dl","mg/dl","mg/dl","mg/dl"};

        return unit;
    }

    public Integer[] getImage(){
        Integer[] image = {R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple};

        return image ;
    }

    public String[]  getinfo1(){
        String[] info1 = {"The blood glucose level", "The blood sodium level", "The blood potassium level",
                "The blood cholesterol level", "The blood LDL level", "The normal HDL level",
                "The blood Trigryceride level"};
        return info1;
    }

    public String[]  getinfo2(){
        String[] info2 = {"Low blood   78  mg/dl",
                "Low blood   120 mmol/L",
                "Low blood   3.4 mEq/L",
                "Normal                 0 - 200 mg/dl",
                "Normal                 - mg/dl",
                "Low blood         35 mg/dl",
                "Normal                 0- 150 mg/dl"};
        return info2;
    }
    public String[]  getinfo3(){
        String[] info3 = {"Normal        79 - 110 mg/dl",
                "Normal        121 - 135 mmol/L",
                "Normal        3.5 - 5.0 mEq/L",
                "Borderline(high) 200-240 mg/dl",
                "Borderline(high) 0 - 130 mg/dl",
                "Normal               50 mg/dl up",
                "Borderline(high) 150 - 500 mg/dl"};

        return info3;
    }
    public String[]  getinfo4(){
        String[] info4 = {"High blood  111  mg/dl",
                "High blood  136 up mmol/L",
                "High blood  5.1 mEq/L",
                "High risk              241 mg/dl",
                "High risk              200 - 240 mg/dl",
                "-",
                "High risk              500 mg/dl up"};
        return info4;
    }
    public String[]  getinfo5(){
        String[] info5 = {"" +
                "" +
                "Low blood sugar\n"+
                "If blood sugar levels drop too low, a potentially fatal condition" +
                " called hypoglycemia develops. Symptoms may include lethargy, impaired" +
                " mental functioning; irritability; shaking, twitching, weakness in arm and leg" +
                " muscles; pale complexion; sweating; loss of consciousness.",

                "Low volume\n" +
                        "The hypovolemia (extracellular volume loss) is due to total body sodium loss.The hyponatremia is caused by a relatively smaller loss in total body water.\n" +
                        "\n"+
                        "- any cause of hypovolemia such as prolonged vomiting, decreased oral intake, severe diarrhea\n" +
                        "- diuretic use (due to the diuretic causing a volume depleted state and thence ADH release,and not a direct result of diuretic-induced urine sodium loss)\n" +
                        "- Addison's disease and congenital adrenal hyperplasia in which the adrenal glands do not produce enough steroid hormones (combined glucocorticoid and mineralocorticoid deficiency)\n" +
                        "- pancreatitis\n" +
                        "- Prolonged exercise and sweating, combined with drinking water without electrolytes is the cause of exercise-associated hyponatremia (EAH).It is common in marathon runners and participants of other endurance events.\n" +
                        "- The use of MDMA (ecstasy) can result in hyponatremia.",

                "Low volume\n" +
                        "-",
                "Low volume\n" +
                        "-",

                "low-density lipoprotein (LDL) – carries cholesterol to the cells that need it, but if there's too much cholesterol for the cells to use, it can build up in the artery walls, leading to disease of the arteries; for this reason, LDL is known as \"bad cholesterol\""
                ,
                "high-density lipoprotein (HDL) – carries cholesterol away from the cells and back to the liver, where it's either broken down or passed out of the body as a waste product; for this reason, HDL is referred to as \"good cholesterol\", and higher levels are better"

                ,"-"
        };
        return info5;
    }

    public String[]  getinfo6(){
        String[] info6 = {

                "High blood sugar\n" +
                        "If blood sugar levels remain too high the body suppresses appetite " +
                        "over the short term. Long-term hyperglycemia causes many long-term " +
                        "health problems including heart disease,cancer,eye, kidney," +
                        " and nerve damage.",

                "High volume\n" +
                        "Both sodium and water content increase: Increase in sodium content leads to hypervolemia and water content to hyponatremia.\n" +
                        "\n"+
                        "- cirrhosis of the liver\n" +
                        "- congestive heart failure\n" +
                        "- nephrotic syndrome in the kidneys\n" +
                        "- Excessive drinking of fluids",

                "High volume\n"
                        +"The symptoms of high potassium depend on the level of the mineral in your blood. You may not have any symptoms at all. But if your potassium levels are high enough to cause symptoms, you may have:\n" +
                        "\n" +
                        "- tiredness or weakness\n" +
                        "- a feeling of numbness or tingling\n" +
                        "- nausea or vomiting\n" +
                        "- trouble breathing\n" +
                        "- chest pain\n" +
                        "- palpitations or irregular heartbeats\n" +
                        "- In extreme cases, high potassium can cause paralysis or heart failure. If left untreated, high potassium levels can cause your heart to stop."

                ,       "High volume\n"+
                "Certain medical conditions can affect your cholesterol levels. High blood cholesterol levels can be caused by:\n" +
                "\n" +
                "- diabetes\n" +
                "- hypothyroidism\n" +
                "- metabolic syndrome\n" +
                "- Cushing’s syndrome\n" +
                "- polycystic ovary syndrome (PCOS)\n" +
                "- kidney disease"
                ,"-","-"

                , "High volume\n"+
                "High triglycerides are usually caused by other conditions, such as:\n" +
                "\n" +
                "- Obesity.\n" +
                "- Poorly controlled diabetes.\n" +
                "- An underactive thyroid (hypothyroidism).\n" +
                "- Kidney disease.\n" +
                "- Regularly eating more calories than you burn.\n" +
                "- Drinking a lot of alcohol."
        };
        return info6;
    }


}
