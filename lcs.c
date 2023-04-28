#include<stdio.h>
#include<string.h>
char x[30],y[30];
char b[30][30];
int c[30][30];
void print_lcs(int i,int j){
if(i==0||j==0){
    return;
}
else if(b[i][j]=='d'){
    print_lcs(i-1,j-1);
    printf("%c\t",x[i-1]);
}
else if(b[i][j]=='t'){
    print_lcs(i-1,j);
}
else{
    print_lcs(i,j-1);
}
}
void length(char x[30],char y[30]){
    int m=strlen(x);
    int n=strlen(y);
    b[m+1][n+1];
    c[m+1][n+1];
    for(int i=0;i<=m;i++){
        c[i][0]=0;
    }
    for(int i=0;i<=n;i++)
    {
        c[0][i]=0;
    }
    for(int i=1;i<=m;i++)
    {
        for(int j=1;j<=n;j++)
        {
            if(x[i-1]==y[j-1])
            {
                c[i][j]=c[i-1][j-1]+1;
                b[i][j]='d';
            }
            else if(c[i-1][j]>=c[i][j-1]){
                c[i][j]=c[i-1][j];
                b[i][j]='t';
            }
            else
            {
                c[i][j]=c[i][j-1];
                b[i][j]='r';
            }
        }
    }
    printf("The matrix to show the values of b\n");
    for(int i=0;i<=m;i++)
    {
        for(int j=0;j<=n;j++)
        {
            printf("%c\t",b[i][j]);
        }
        printf("\n");
    }
    printf("The matrix to show the value of c\n");
     for(int i=0;i<=m;i++)
    {
        for(int j=0;j<=n;j++)
        {
            printf("%d\t",c[i][j]);
        }
        printf("\n");
    }
    printf("The longest subsequence is:");
    print_lcs(m,n);
}

int main()
{
    printf("enter the string x:");
    scanf("%s",x);
    printf("enter the string y:");
    scanf("%s",y);
    printf("The content of string x is:\n");
    for(int i=0;i<strlen(x);i++)
    {
        printf("%c\n",x[i]);
    }
    printf("The content of the string y is :\n");
    for(int i=0;i<strlen(y);i++)
    {
        printf("%c\n",y[i]);
    }
    length(x,y);
    return 0;
}
