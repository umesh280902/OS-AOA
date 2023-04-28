#include <stdio.h>
#define INF 999
int d[10][10];
int p[10][10];
int g[10][10];
int v, e;
void readgraph()
{
    int i, j;
    printf("\nEnter the graph:\n");
    for (i = 0; i < v; i++)
    {
        for (j = 0; j < v; j++)
        {
            scanf("%d", &g[i][j]);
        }
    }
}
void displaygraph(int g[10][10])
{
    int i, j;
    for (i = 0; i < v; i++)
    {
        for (j = 0; j < v; j++)
        {
            printf("%d\t", g[i][j]);
        }
        printf("\n");
    }
    printf("\n");
}
void initialization()
{
    for (int i = 0; i < v; i++)
    {
        for (int j = 0; j < v; j++)
        {
            if (i == j)
            {
                d[i][j] = 0;
                p[i][j] = -1;
            }
            else if (g[i][j] == 0)
            {
                d[i][j] = INF;
                p[i][j] = -1;
            }
            else
            {
                d[i][j] = g[i][j];
                p[i][j] = i;
            }
        }
    }
}
void floydwarshall()
{
    int i, j, k;
    for (k = 0; k < v; k++)
    {
        for (i = 0; i < v; i++)
        {
            for (j = 0; j < v; j++)
            {
                if (d[i][j] <= d[i][k] + d[k][j])
                {
                    continue;
                }
                else
                {
                    d[i][j] = d[i][k] + d[k][j];
                    p[i][j] = p[k][j];
                }
            }
        }
    }
}
void printpath(int s, int v)
{
    if (v == s)
    {
        printf(" %d ", s);
    }
    else if (p[s][v] == -1)
    {
        printf("\nNo path exists\n");
    }
    else
    {
        printpath(s, p[s][v]);
        printf("->");
        printf("%d", v);
    }
}
int main()
{
    printf("\nEnter number of vertices: \n");
    scanf("%d", &v);
    readgraph();
    printf("\nGraph is: \n");
    displaygraph(g);
    initialization();
    printf("\nAfter initialization\n");
    printf("\nD Matrix\n");
    displaygraph(d);
    printf("\nP Matrix\n");
    displaygraph(p);
    floydwarshall();
    printf("\nAfter floyd Warshall\n");
    printf("\nD Matrix\n");
    displaygraph(d);
    printf("\nP Matrix\n");
    displaygraph(p);
    printf("\nPrinting Path\n");
    for (int i = 0; i < v; i++)
    {
        for (int j = 0; j < v; j++)
        {
            if (i == j)
                continue;
            printf("path from %d to %d is ", i, j);
            printpath(i, j);
            printf("\n");
        }
    }
    return 0;
}