/**
 * @author LZD	2019/01/31
 */
/*
 * ���ӣ�https://www.nowcoder.com/questionTerminal/abc3fe2ce8e146608e868a70efebf62e
 * ��Դ��ţ����
 * ����ߣ�������
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * 
 * ����˼·�������ԣ�������⣩
 * ��������ѡ������½ǿ�ʼ��Ѱ��
 * (Ϊʲô�������Ͻǿ�ʼ��Ѱ�����Ͻ����Һ����¶��ǵ�����
 * ��ô����һ���㣬�������Һ����»����һ����·��
 * �������ѡ������½ſ�ʼ��Ѱ�Ļ���������ھ����ң����С�ھ�����)��
 */
package array;

public class Find {
    public boolean find(int target,int [][] array) {
    	int m = array.length - 1;
    	int i = 0;
    	while(m >= 0 && i < array[0].length) {
    		if(array[m][i] > target)
    			m--;
    		else if(array[m][i] < target) {
    			i++;
    		}else 
    			return true;
    		}
    	return false;
    }
    
    public static void main(String[] args) {
		
	}
}