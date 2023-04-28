#include<stdio.h>
#include<string.h>
char x[30],y[30];
char b[30][30];
int c[30][30];
void printLCS(int i,int j){
    if(i==0||j==0){
        return;
    }
    else if(b[i][j]=='d'){
        printLCS(i-1,j-1);
        printf("%c\t",x[i-1]);
    }
    else if(b[i][j]=='t'){
        printLCS(i-1,j);
    }
    else{
        printLCS(i,j-1);
    }
}
void length(char x[30],char y[30]){
   int m=strlen(x);
   int n=strlen(y);
   b[m+1][n+1],c[m+1][n+1];
   //m is for the row and n is for the column
   for(int i=0;i<=m;i++){
    c[i][0]=0;
   }
    for(int j=0;j<=n;j++){
    c[0][j]=0;
   }
   for(int i=1;i<=m;i++){
    for(int j=1;j<=n;j++){
        if(x[i-1]==y[j-1]){
            b[i][j]='d';
            c[i][j]=c[i-1][j-1]+1;
        }
        else if(c[i-1][j]>=c[i][j-1]){
            b[i][j]='t';
            c[i][j]=c[i-1][j];
        }
        else{
            b[i][j]='s';
            c[i][j]=c[i][j-1];
        }
    
    }
   }
   printf("the matrix to show the table of matrix b:\n");
   for(int i=0;i<=m;i++){
    for(int j=0;j<=n;j++){
        printf("|%c\t",b[i][j]);
    }
    printf("|\n");
   }
   printf("\n");
   printf("the matrix to show the table of matrix c:\n");
   for(int i=0;i<=m;i++){
    for(int j=0;j<=n;j++){
        printf("|%d\t",c[i][j]);
    }
    printf("|\n");
   }
    printf("the longest common subsequence is:");
    printLCS(m,n);
}

void main(){
    printf("enter the sequence for x:");
    scanf("%s",x);
    printf("enter the sequence for y:");
    scanf("%s",y);
    printf("the sequence for x:");
    for(int i=0;i<strlen(x);i++){
        printf("%c\t",x[i]);
    }
    printf("\n\n");
    printf("the sequence for y:");
    for(int i=0;i<strlen(y);i++){
        printf("%c\t",y[i]);
    }
    printf("\n\n");
    length(x,y);

}