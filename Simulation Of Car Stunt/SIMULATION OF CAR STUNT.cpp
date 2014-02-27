
#include<iostream.h>
#include<stdlib.h>
#include<GL/glut.h>
#include<math.h>
#include<stdio.h>
#include<string.h>


void cartop( int x , int y , int z , GLfloat length , GLfloat breadth , GLfloat height , GLenum mode);
void carbase( int x , int y , int z , GLfloat length , GLfloat breadth , GLfloat height , GLenum mode);
void window();
void drawwheel();
void drawexst();
void drawbulb();
void drawBridge();
void stadium();
void man();


int submenu,idle_idl=1,idl1=0,id3=1,mflag=0,idl2=0,flag_rot1=0,idl3=0;
double t=0,s=0,a=1,b=1,c=1,d,e=0,f=0,g=0,h=0,i=0,j=0,k=0,r=0,z=0,angle1 =35,angle2=0,angle3=0,id4=1,l=0;
void dis(){
glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);


if(!mflag)
{
glClearColor(0,0,0.5,1);
	glPushMatrix();
	char string[]="SIMULATION OF CAR STUNT";
char string1[]="-ASHISH R";
char string2[]="-BHARGAVA PEJAKALA";
char string3[]="Right Click For menu";

glPushMatrix();
glColor3f(1,0,0);
glTranslatef(0,0,-7);
glRasterPos2f(-5,0);
for(int l=0;l<=strlen(string);l++)
{
glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,string[l]);
}
glPopMatrix();

glPushMatrix();
glColor3f(1,0,0);
glTranslatef(0,0,-7);
glRasterPos2f(1,-1.5);
for( l=0;l<=strlen(string2);l++)
{
glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,string2[l]);
}
glPopMatrix();



glPushMatrix();
glColor3f(1,0,0);
glTranslatef(0,0,-7);
glRasterPos2f(1,-0.8);
for(l=0;l<=strlen(string1);l++)
{
glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,string1[l]);
}
glPopMatrix();

glPushMatrix();
glColor3f(1,0,0);
glTranslatef(0,0,-7);
glRasterPos2f(-2,-3);
for(l=0;l<=strlen(string3);l++)
{
glutBitmapCharacter(GLUT_BITMAP_9_BY_15,string3[l]);
}
glPopMatrix();


glPopMatrix();
}

else


{
glClearColor(0,1,0.8,1);


glPushMatrix();
glTranslatef ( -30 , 0 , -50 );
glRotatef( angle1, 1, 0 , 0);
 
//Draw the stadium
  stadium();
  
  //draw Bridges
  drawBridge();
  
  //Draw men
  for( l=0;l<=250;l=l+25)
  {
   glPushMatrix();
   glTranslatef(0,0,-85);
   man();
   glPopMatrix();
  }

  glPopMatrix();


  
  glPushMatrix();

  glTranslatef ( -30+t , -5+s , -35+r );

glScalef(a,b,c);
glRotatef(14,0,0,1);

glRotatef( angle1, 1, 0 , 0);
glRotatef( angle2, 0, 1 , 0);
glRotatef( angle3, 0, 0 , 1);

   glPushMatrix();
 
   drawwheel();
   drawexst();
   drawbulb();
   glPopMatrix();
  
  
    glScalef(2,0.5,1);		
    glColor3f(1,0,0);
    
	
	glPushMatrix();
     carbase(-2.5,-2.5,2.5,5,5,5,GL_POLYGON);
     cartop(-2.5,2.5,2.5,5,5,5,GL_POLYGON);
  glPopMatrix();

  glColor3f(1,0,0);
  window();

glPopMatrix();
}

glFlush();
glutSwapBuffers();
}





void myRe( int width , int height ){
	glViewport( 0 , 0 , width , height );
	glMatrixMode( GL_PROJECTION );
   glLoadIdentity();
	gluPerspective( 75 , (GLfloat) width / (GLfloat) height , 0.001 , 1000 );
	glMatrixMode( GL_MODELVIEW );
}




void cartop( int x , int y , int z , GLfloat length , GLfloat breadth , GLfloat height , GLenum mode){
	
	GLfloat vertices[8][3] = { { x , y , z + breadth } , { x , y + height , z + breadth } , {x ,  y + height ,  z}, { x ,  y ,  z } ,
							 { x + length  ,  y ,  z + breadth } , { x + length  ,  y + height ,  z + breadth } ,  { x + length ,  y + height , z } , { x + length ,  y , z }  
						   };
glPushMatrix();

	glBegin( mode );
	glColor3ub(196,77,900); 
	glVertex3fv( vertices[0] );
	 glVertex3fv( vertices[4] );
	 glVertex3fv( vertices[7] );
	 glVertex3fv( vertices[3] );
	glEnd();


	
	glBegin( mode );
	glColor3ub(189,100,100); 
	glVertex3fv( vertices[0] );
	glColor3ub(22,45,99); 
	glVertex3fv( vertices[3] );
	glColor3ub(187,234,459); 
	 
	glVertex3f(0.5*vertices[2][0],vertices[2][1] ,vertices[2][2] );
	glColor3ub(255,40,9); 
	 
	 glVertex3f( 0.5*vertices[1][0],vertices[1][1] ,vertices[1][2]);

	 glEnd();

	
	 
	 glBegin( mode );
	 glColor3ub(189,100,100);
	 glVertex3f( 0.5*vertices[1][0],vertices[1][1] ,vertices[1][2]);
	 glColor3ub(22,45,99); 
	
	 glVertex3f(0.5*vertices[2][0],vertices[2][1] ,vertices[2][2] );
	 glColor3ub(187,234,459); 
	
	 glVertex3f( 0.5*vertices[6][0],vertices[6][1] ,vertices[6][2] );
	 glColor3ub(255,40,9); 
	
	 glVertex3f( 0.5*vertices[5][0],vertices[5][1] ,vertices[5][2] );
	glEnd();

	glBegin( mode );
	glColor3ub(189,100,100);
	glVertex3f(0.5*vertices[2][0],vertices[2][1] ,vertices[2][2] );
	 glColor3ub(22,45,99); 
	 
	glVertex3fv( vertices[3] );
	glColor3ub(187,234,459); 
	
	glVertex3fv( vertices[7] );
	glColor3ub(255,40,9); 
	
	glVertex3f( 0.5*vertices[6][0],vertices[6][1] ,vertices[6][2] );
	 
	 glEnd();

	
	glBegin( mode );
	glColor3ub(189,100,100);
	glVertex3fv( vertices[4] );
	glColor3ub(22,45,99); 
	 
	glVertex3f( 0.5*vertices[5][0],vertices[5][1] ,vertices[5][2] );
	glColor3ub(187,234,459); 
	
	 glVertex3f( 0.5*vertices[6][0],vertices[6][1] ,vertices[6][2] );
	glColor3ub(255,40,9); 
	 
	 glVertex3fv( vertices[7] );
	glEnd();

	glBegin( mode );
	glColor3ub(189,100,100); 
	glVertex3fv( vertices[0] );
	glColor3ub(22,45,99); 
		 
	glVertex3f( 0.5*vertices[1][0],vertices[1][1] ,vertices[1][2]);
	glColor3ub(187,234,459); 
	
	glVertex3f( 0.5*vertices[5][0],vertices[5][1] ,vertices[5][2] );
	glColor3ub(255,40,9); 
	
		 glVertex3fv( vertices[4] );
	glEnd();
    glPopMatrix();
}

void carbase( int x , int y , int z , GLfloat length , GLfloat breadth , GLfloat height , GLenum mode){
	
	GLfloat vertices[8][3] = { { x , y , z + breadth } , { x , y + height , z + breadth } , {x ,  y + height ,  z}, { x ,  y ,  z } ,
							 { x + length  ,  y ,  z + breadth } , { x + length  ,  y + height ,  z + breadth } ,  { x + length ,  y + height , z } , { x + length ,  y , z }  
						   };
   glPushMatrix();

	glBegin( mode );
	 glColor3ub(199,8,20);
	 glVertex3fv( vertices[0] );
	 glColor3ub(10,77,9);
	
	 glVertex3fv( vertices[4] );
	  glColor3ub(140,55,22);
	
	 glVertex3fv( vertices[7] );
	  glColor3ub(222,43,2);
	
	 glVertex3fv( vertices[3] );
	glEnd();

	glBegin( mode );
	
	 glColor3ub(199,8,20);
	 glVertex3fv( vertices[1] );
	 glColor3ub(10,77,9);
	 
	 glVertex3fv( vertices[2] );
	 glColor3ub(140,55,22);
	 
	 glVertex3fv( vertices[6] );
	 glColor3ub(222,43,2);
	 
	 glVertex3fv( vertices[5] );
	glEnd();

	glBegin( mode );
	
	 glColor3ub(199,8,20);
	 glVertex3fv( vertices[2] );
	 glColor3ub(10,77,9);
	 
	 glVertex3fv( vertices[3] );
	 glColor3ub(140,55,22);
	 
	 glVertex3fv( vertices[7] );
	 glColor3ub(222,43,2);
	 
	 glVertex3fv( vertices[6] );
	glEnd();

	glBegin( mode );
	
 glColor3ub(199,8,20);
	 glVertex3fv( vertices[0] );
	 glColor3ub(10,77,9);
	 glVertex3fv( vertices[3] );
	glColor3ub(140,55,22);
	 glVertex3fv( vertices[2] );
	 glColor3ub(222,43,2);
	 glVertex3fv( vertices[1] );
	glEnd();

	glBegin( mode );
	
      glColor3ub(199,8,20);
	 glVertex3fv( vertices[4] );
	  glColor3ub(10,77,9);
	 
	 glVertex3fv( vertices[5] );
	  glColor3ub(140,55,22);
	 
	 glVertex3fv( vertices[6] );
	  glColor3ub(222,43,2);
	 
	 glVertex3fv( vertices[7] );
	glEnd();

	glBegin( mode );
	
     glColor3ub(199,8,20);
	 glVertex3fv( vertices[0] );
	 glColor3ub(78,21,18);
	 
	 glVertex3fv( vertices[1] );
	 glColor3ub(10,77,9);
	 
	 glVertex3fv( vertices[5] );
	 glColor3ub(140,55,22);
	 
	 glVertex3fv( vertices[4] );
	glEnd();
glPopMatrix();
}


void window()
{

glBegin(GL_POLYGON);

glColor3ub(255,255,34);
glVertex3f(-1.0,3.25,1.9);
glColor3ub(67,255,255);

glVertex3f(-1.0,6.25,1.9);
glColor3ub(67,255,255);

glVertex3f(-0.01,6.25,1.9);
glColor3ub(255,255,34);

glVertex3f(-0.01,3.25,1.9);
glEnd();





glColor3f(1,0,0);
glBegin(GL_POLYGON);
glColor3ub(255,255,34);

glVertex3f(1.5,3.25,1.9);
glColor3ub(67,255,255);

glVertex3f(1.5,6.25,1.9);
glColor3ub(67,255,255);

glVertex3f(0.5,6.25,1.9);
glColor3ub(255,255,34);

glVertex3f(0.5,3.25,1.9);
glEnd();


glPushMatrix();
glColor3f(1,0,0);
glTranslatef(0,0,-0.4);
glBegin(GL_POLYGON);

glColor3ub(255,255,34);

glVertex3f(-1.0,3.25,7.5);
glColor3ub(67,255,255);

glVertex3f(-1.0,6.25,7.5);
glColor3ub(67,255,255);

glVertex3f(-0.01,6.25,7.5);

glColor3ub(255,255,34);

glVertex3f(-0.01,3.25,7.5);
glEnd();

glColor3f(1,0,0);
glBegin(GL_POLYGON);
glColor3ub(255,255,34);

glVertex3f(1.5,3.25,7.5);
glColor3ub(67,255,255);

glVertex3f(1.5,6.25,7.5);
glColor3ub(67,255,255);

glVertex3f(0.5,6.25,7.5);
glColor3ub(255,255,34);

glVertex3f(0.5,3.25,7.5);
glEnd();
glPopMatrix();

glColor3f(1,0,0);
glBegin(GL_POLYGON);
glColor3ub(255,255,34);

glVertex3f(-1.8,3.4,2.4);
glColor3ub(67,255,255);

glVertex3f(-1.8,3.4,6.9);
glColor3ub(67,255,255);

glVertex3f(-1.2,6.4,6.9);
glColor3ub(255,255,34);

glVertex3f(-1.2,6.4,2.4);

glEnd();


}

void drawwheel()
{

	
	/*wheel 1*/
     
	glColor3f(0,0,0);
	   glPushMatrix();
	    GLUquadric *q = gluNewQuadric();
        glTranslatef (-2.2, -0.9,2.3 );
        
		glRotatef (180 , 0 , 1 , 0 );
         gluDisk (q,0.3,1,100,100); 
    	    gluDeleteQuadric ( q );
         glPopMatrix();



		 
		 /*wheel 2*/
	 glPushMatrix();
	    q = gluNewQuadric();
        glTranslatef (-1.8, -1,6.7+k );
        
		glRotatef (180 , 0 , 1 , 0 );
         gluDisk (q,0.3 ,1,100,100); 
    	    gluDeleteQuadric ( q );
         glPopMatrix();


		 //wheel 3
		 glPushMatrix();
	    q = gluNewQuadric();
        glTranslatef (5, -0.9,2.3);
        glRotatef (180 , 0 , 1 , 0 );
         gluDisk (q,0.3 ,1,100,100); 
    	    gluDeleteQuadric ( q );
         glPopMatrix();


		 //wheel 4
		 glPushMatrix();
	    q = gluNewQuadric();
        glTranslatef (5, -1,6.7 );
        
		glRotatef (180 , 0 , 1 , 0 );
         gluDisk (q,0.3 ,1,100,100); 
    	    gluDeleteQuadric ( q );
         glPopMatrix();


} 

void stadium()
{
glPushMatrix();
        GLUquadric *q = gluNewQuadric();
		glTranslatef ( 49 , 0 ,70 );
        
		glPushMatrix();
		glColor3ub(189,25,57);
        glRotatef ( 90 , 1 , 0 , 0 );
        gluCylinder ( q , 150 , 150 , 10 , 10 , 10 );
        glPopMatrix();
		
		gluDeleteQuadric ( q );
       glPopMatrix();





}

void drawexst()
{
glPushMatrix();
        GLUquadric *q = gluNewQuadric();
		glColor3f(0,0,0);
        glTranslatef ( -5 , -1.1 ,3.5 );
        glRotatef ( 90 , 0 , 1 , 0 );
        gluCylinder ( q , 0.3 , 0.3 , 6 , 10 , 10 );
         
   
		gluDeleteQuadric ( q );
    glPopMatrix();
}

void drawbulb()
{
    glPushMatrix();
	glColor3f(1,1,0);
	glTranslatef(6.3,0,3);
	glutSolidSphere(0.5, 50, 50);
     glPopMatrix();




  glPushMatrix();
	glColor3f(1,1,0);
	glTranslatef(6.3,0,6);
	glutSolidSphere(0.5, 50, 50);
    glPopMatrix();


	//back wheel

 glPushMatrix();
	glColor3f(1,1,0);
	glTranslatef(-4.2,0,3);
	glutSolidSphere(0.5, 50, 50);
     glPopMatrix();




  glPushMatrix();
	glColor3f(1,1,0);
	glTranslatef(-4.2,0,6);
	glutSolidSphere(0.5, 50, 50);
    glPopMatrix();







}

void drawBridge()
{


	glPushMatrix();
	

glTranslatef ( 17 , -6, 14 );
glRotatef(10,0,1,0);

//first slanted bridge
glTranslatef(-10,0,0);
glPushMatrix();
glColor3ub(200,200,100);
glTranslatef(5,2,-10);
glRotatef(-76,0,0,1);
glRotatef(90,0,1,0);
glScalef(1,2,1);
glRectf(-10,-10,3,3);
glPopMatrix();

 
//right leg
glPushMatrix();
glTranslatef(10,3.8,-12);
glRotatef(-90,0,0,1);
carbase(0,0,0,7.3,1,2,GL_POLYGON);
glPopMatrix();

//left leg
glPushMatrix();
glTranslatef(9,3.4,-2.5);
glRotatef(-90,0,0,1);
carbase(0,0,0,7.3,1,2,GL_POLYGON);
glPopMatrix();

//end of first bridge

glTranslatef(20,0,0);
//second slant
glPushMatrix();
glColor3ub(200,200,100);
glTranslatef(60,2,-10);
glRotatef(76,0,0,1);
glRotatef(90,0,1,0);
glScalef(1,2,1);
glRectf(-10,-10,3,3);
glPopMatrix();

//plane bridge
glPushMatrix();
glColor3ub(200,200,100);
glTranslatef(33,4+f,-10);
glRotatef(90+e,0,0,1);
glRotatef(90,0,1,0);
glScalef(1,2,1);
glRectf(-10,-10,3,3);
glPopMatrix();

//Ground level

glPushMatrix();
glColor3ub(400,400,100);
glTranslatef(200,-7.5,700);
glRotatef(90,0,0,1);
glRotatef(90,0,1,0);
glScalef(200,200,100);
glRectf(-10,-10,600,600);

glPopMatrix();






//legs1
glPushMatrix();
glTranslatef(27,3.8+i,-12);
glRotatef(-g,1,0,0);
glRotatef(-90,0,0,1);
carbase(0,0,0,7.3,1,2,GL_POLYGON);
glPopMatrix();


//leg2
glPushMatrix();
glTranslatef(27,3.8+j,-2.5);
glRotatef(-h,0,0,1);

glRotatef(-90,0,0,1);
carbase(0,0,0,7.3,1,2,GL_POLYGON);
glPopMatrix();


glPushMatrix();
glTranslatef(50,3.8,-12);
glRotatef(-90,0,0,1);
carbase(0,0,0,7.3,1,2,GL_POLYGON);
glPopMatrix();



glPushMatrix();
glTranslatef(50,3.8,-2.5);
glRotatef(-90,0,0,1);
carbase(0,0,0,7.3,1,2,GL_POLYGON);
glPopMatrix();


glPushMatrix();
glTranslatef(53,3.8,-12);
glRotatef(-90,0,0,1);
carbase(0,0,0,7.3,1,2,GL_POLYGON);
glPopMatrix();



glPushMatrix();
glTranslatef(53,3.8,-2.5);
glRotatef(-90,0,0,1);
carbase(0,0,0,7.3,1,2,GL_POLYGON);
glPopMatrix(); 


glPopMatrix();
}

void man()
{
//to draw the man
	glPushMatrix();
      glTranslatef(-90+l,0.8,0); 
	  

	glScalef(0.7,0.7,0.4);

	glPushMatrix();

//draw the body
glColor3ub(100,45,3);
glScalef(1,2,1);
glutWireSphere(2,50,50);
glPopMatrix();

//draw the face
glPushMatrix();
glTranslatef(0.1,5.4,0);
glColor3ub(34,15,6);
glutWireSphere(1.5,50,50);
glPopMatrix();
//Draw the left hand
glPushMatrix();
glTranslatef(1.9,-0.1,1);
glColor3ub(200,200,100 );
gluCylinder(gluNewQuadric(),0.5,0.5,4.0,50,50);
glPopMatrix();

//Draw the right hand
glPushMatrix();
glTranslatef(-1.9,-0.1,1); 
glColor3ub(200,200,100);
gluCylinder(gluNewQuadric(),0.5,0.5,4.0,50,50);
glPopMatrix();

//draw left leg
glPushMatrix();
glPushMatrix();
glTranslatef(1.4,-2.9,0);

//glRotatef(l,1,0,0);
glRotatef(15,0,0,1);
glRotatef(90,1,0,0);
glColor3ub(200,200,100);
gluCylinder(gluNewQuadric(),0.9,0.5,6.0,50,50);
glPopMatrix();

glPushMatrix();

  
glTranslatef(2.8,-8.7,0);

glScalef(1,0.8,3);
glColor3ub(199,45,13);
glutSolidCube(0.8);
glPopMatrix();




glPopMatrix();

//draw right leg
glPushMatrix();
glRotatef(r,1,0,0);
glPushMatrix();
glTranslatef(-1,-2.9,0);
glRotatef(-15,0,0,1);
glRotatef(90,1,0,0);
glColor3ub(200,200,100);
gluCylinder(gluNewQuadric(),0.9,0.5,6.0,50,50);
glPopMatrix();

glPushMatrix();

  
glTranslatef(-2.5,-8.7,0);
glScalef(1,0.8,3);
glColor3ub(199,45,13);
glutSolidCube(0.8);
glPopMatrix();
glPopMatrix();
glPopMatrix();

	}



void idle()
{

//safe

  //straight motion
	if(id4==1&&idl2==1&&idl1==0&&idl3==0)
	{ 
	
	if(t<30)	
	{
		t+=2;
	 s=0.2493*t;
	}
		if(t>=30&&t<37)
		{t+=2;
		angle3-=0.8;
		}
	if(t>=37&&flag_rot1==0)
		{flag_rot1=1;
		 s=s-1.5;
		 r=r-10;	 
	}
		 if(t>=37&&flag_rot1&&t<=60)
	  {
	    t=t+2;	
        }
	
	if(t>60)
		id4=0;
	}

	


//accident
if(id3==1&&idl1==1&&idl2==0&&idl3==0)
{ 
	
	if(idle_idl==1){	
	if(t>36)
		{
	     s=s-6.2;
		  a=0.3;	
		 idle_idl=0;
		}
		else

       if(t>=33.0&&t<=36.0)
    {
		angle3-=30;
    	  t+=1;
		 s-=0.2;
	 
	 }else
	 {
		    t+=1;
		
	 s=0.2493*t;
	 }
	}
	 if(idle_idl==0)
{
e=e+5;
f=f-1.5;
g=75;
h=88;
i=i-0.5;
j=j-0.5;
k=7;
if(e==45)
{
id3=0;
//idl1=0;
angle3=0;
}
}
}
	

//fast accident
if(id3==1&&idl3==1&&idl2==0&&idl1==0)
{ 
	if(idle_idl==1){	
	if(t>36)
		{
	     s=s-6.2;
		  a=0.3;	
		 idle_idl=0;
		}
		else

       if(t>=33.0&&t<=36.0)
    {
		angle3-=30;
    	  t+=4;
		 s-=0.1;
	 
	 }else
	 {
		    t+=4;
		
	 s=0.2493*t;	 }
	}
	 if(idle_idl==0)
{
e=e+5;
f=f-1.5;
g=75;
h=88;
i=i-0.5;
j=j-0.5;
k=7;
if(e==45)
{
id3=0;
angle3=0;
}
}
}
glutPostRedisplay();
}


void myMenu(int id2)
{
	
	switch(id2)
	{
	case 3:	mflag=1;
		   glutPostRedisplay();
           break;
	case 4:
		mflag=0;
		idl2=0;
	   idl1=0;
	   idl3=0;
	   id4=1;
	   t=0;
	   s=0;
	   r=0;
	   e=f=g=h=i=j=k=s=t=0;
	   a=1;
	   angle3=0;
	   angle1=35;
	   angle2=0;
	   flag_rot1=0;
		
		glutPostRedisplay();
        break;
	}
	
}





void speed(int id1)
{
switch(id1)
{
case 1:if(mflag)
	   {
       idl2=1;
	   idl1=0;
	   idl3=0;
	   id4=1;
	   t=0;
	   s=0;
	   r=0;
	   e=f=g=h=i=j=k=s=t=0;
	   a=1;
	   angle3=0;
	   flag_rot1=0;
	   }
	glutPostRedisplay();

	   break;

case 2:    if(mflag) 	
		   {
			   idl1=1;
	 	    id3=1;
			idle_idl=1;
			e=f=g=h=i=j=k=s=t=0;
			a=1;
			angle3=0;
		  idl2=0;
		  idl3=0;
		   t=0;
		   s=0;
		   r=0;
		   }
			glutPostRedisplay();
	       break;

case 3:    	if(mflag) 	
		   {
			   idl3=1;
	 	    id3=1;
			idle_idl=1;
			e=f=g=h=i=j=k=s=t=0;
			a=1;
			angle3=0;
		  idl2=0;
		  idl1=0;
		   t=0;
		   s=0;
		   r=0;
		   }
	     glutPostRedisplay();
	       break;

}
}


int main(int argc,char **argv){
glutInit(&argc,argv);
glutInitWindowSize(1250,728);
glutInitWindowPosition(10,10);
glutInitDisplayMode(GLUT_DOUBLE|GLUT_RGB);

glutCreateWindow("SIMULATION OF CAR STUNT");
glutReshapeFunc(myRe);
glutDisplayFunc(dis);

glutIdleFunc(idle);
 
submenu=glutCreateMenu(speed);
glutAddMenuEntry("Accident(speed<80)", 2);
glutAddMenuEntry("Safe(speed 80-100)", 1);
glutAddMenuEntry("Accident(speed >100)", 3);
	
glutCreateMenu(myMenu);
	glutAddMenuEntry("Start", 3);
	glutAddSubMenu("Input",submenu);
	glutAddMenuEntry("stop", 4);
	
	glutAttachMenu(GLUT_RIGHT_BUTTON);
  

glEnable(GL_DEPTH_TEST);
glutMainLoop();
return 0;
}
