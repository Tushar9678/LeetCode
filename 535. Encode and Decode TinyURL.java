public class Codec {

    HashMap<String,String> LongToShortMap= new HashMap<>();
    HashMap<String, String> ShortToLongMap = new HashMap<>();
    String seed = "ABCDEFGHIJKLMNOPQRSTWXYZ0123456789abcdefghijklmnopqrstvwxyz";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(LongToShortMap.containsKey(longUrl)){
            return LongToShortMap.get(longUrl);
        }

        String result = "";
        // keep generating random to short string until we find
        //not priviously used string

        while(true){
            result = generateRandomString();

            if(!ShortToLongMap.containsKey(result)){
                ShortToLongMap.put(result,longUrl);
                LongToShortMap.put(longUrl,result);
                break;
            }
        }
        return result;

        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(!ShortToLongMap.containsKey(shortUrl)){
            return null;
        }
        return ShortToLongMap.get(shortUrl);
    }

    private String generateRandomString(){
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for(int i=0; i<6; i++){
            int j =r.nextInt(seed.length());
            sb.append(seed.charAt(j));
        }
        return sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
