class Solution {
    public String reverseVowels(String s) {
        char[] arr=s.toCharArray();

        int li=0;
        int ri =s.length()-1;

        while(li<ri){
            if(isVowel(arr[li]) && isVowel(arr[ri])){
                char temp=arr[li];
                arr[li]=arr[ri];
                arr[ri] = temp;
                li++;
                ri--;
            }else if(isVowel(arr[li])==true && isVowel(arr[ri])==false){
                ri--;

            }else if(isVowel(arr[li])==false && isVowel(arr[ri])==true){
                li++;
            }else {
                li++;
                ri--;
            }
        }

        return new String(arr);

    }

    boolean isVowel(char ch){
        if(ch=='u'||ch=='U') return true ;
        else if (ch=='a'||ch=='A') return true ;
        else if (ch=='e'||ch=='E') return true ;
        else if (ch=='i'||ch=='I') return true ;
        else if (ch=='o'||ch=='O') return true ;
        else return false;
    }
}