import java.util.Scanner;
class Student
{
    int Maths;
    int Science;
    int Social;
    int English;
    int Hindi;
    int Telugu;
    Double averageMarks;
    double totalMarks;

    void inputMarks()
    {
        
            Scanner marks=new Scanner(System.in);

            System.out.print("Enter the marks in Maths: ");
            Maths= marks.nextInt();  

            System.out.print("Enter the marks in Science: "); 
            Science=marks.nextInt();

            System.out.print("Enter the marks in Social: "); 
            Social=marks.nextInt();

            System.out.print("Enter the marks in English: "); 
            English=marks.nextInt();

            System.out.print("Enter the marks in Hindi: "); 
            Hindi=marks.nextInt();

            System.out.print("Enter the marks in Telugu: "); 
            Telugu=marks.nextInt();

            marks.close();
    }
    void calculateTotal()

      {
         totalMarks= Maths+Science+Social+English+Hindi+Telugu;
      }

     void calculateAverage()
       {
           averageMarks= totalMarks/6;
        

            System.out.println("TotalMarks:" +totalMarks);
            System.out.println("AverageMarks:" +averageMarks);

             if(averageMarks>=90) System.out.print("Grade: A+");

                else if(averageMarks>=80)  System.out.print("Grade: A");

                   else if(averageMarks>=70)  System.out.print("Grade: B+");

                       else if(averageMarks>=60)  System.out.print("Grade: B");

                           else if(averageMarks>=50)  System.out.print("Grade: C");

                                else if(averageMarks>=35)  System.out.print("Grade: D");

                                    else  System.out.print("Grade: F");
        }
    }
    


class StudentGradeCalculatorMain
 {
    public  static void main(String[]args)
    {
      Student marks=new Student ();
          marks.inputMarks();
          marks.calculateTotal();
          marks.calculateAverage();
        }


}