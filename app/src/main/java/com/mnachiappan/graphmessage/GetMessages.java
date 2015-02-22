//package com.mnachiappan.graphmessage;
//
//import android.os.AsyncTask;
//
//import org.apache.http.NameValuePair;
//import org.json.JSONObject;
//
//import java.util.List;
//
///**
//* Created by meyyappan.nachiappan on 15-02-22.
//*/
//public class GetMessages extends AsyncTask<Long, Void, List<JSONObject>> {
//    @Override
//    protected List<JSONObject> doInBackground(Long... params) {
//        final long lastId = params[0];
//        NameValuePair id = new NameValuePair() {
//            @Override
//            public String getName() {
//                return "_id";
//            }
//
//            @Override
//            public String getValue() {
//                return String.valueOf(lastId);
//            }
//        };
//
//        /*
//        NameValuePair id = new NameValuePair() {
//                @Override
//                public String getName() {
//                    return "_id";
//                }
//
//                @Override
//                public String getValue() {
//                    return "14";
//                }
//            };
//            paramsPost.add(id);
//            JSONObject jsn = jParser.makeHttpRequest("http://www.statuses.bugs3.com/get_rows.php", "GET", paramsPost);
//         */
//
//    }
//}
