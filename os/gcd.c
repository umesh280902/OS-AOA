#include<stdio.h>
void main()
{
int gcd,a,b;
clrscr();
printf("enter two numbers\n");
scanf("%d%d",&a,&b);

asm mov ax,a;
asm mov bx,b;
l1:
asm cmp ax,bx;
asm jz l;
asm jc m;
asm jmp n;
m:
asm sub bx,ax;
asm loop l1;
n:
asm sub ax,bx;
asm loop l1;
l:
asm mov gcd,ax;
printf("GCD of the two numbers is %d\n",gcd);
int a1,b1,temp;
printf("Please enter first number: ");
scanf("%d",&a1);
printf("Please enter second number: ");
scanf("%d",&b1);
temp = a1;
asm mov ax,a1
asm mov bx,b1
bck:
asm cmp ax,0000h
asm jz ex
asm cmp bx,0000h
asm jz ex
asm div bl
asm cmp ah,00h
asm jz ex
temp = temp + a1;
asm mov ax,temp
asm mov bx,b1
asm jmp bck
ex:
printf("The LCM is: %d\n",temp);
getch();
}
