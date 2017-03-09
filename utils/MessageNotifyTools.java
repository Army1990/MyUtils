package com.shanpiao.common.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.shanpiao.manage.base.AppBase;
import com.shanpiao.ticket.R;


/**
 * Created by Hornen on 15/11/16.
 */
public class MessageNotifyTools {

    private static Context cxt;

    public static void setContext(Context context) {
        cxt = context;
    }

    public static Context getContext() {
        return cxt;
    }

    public static void showToast(final String msg) {

        verifyContext();

        showToast(getContext(), msg);
    }

    public static void showToast(final int resId) {
        verifyContext();

        showToast(getContext(), resId);
    }

    public static void showToast(final Context cxt, final String msg) {
        AppBase.runOnDispatcher(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(cxt, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void showToast(final Context cxt, final int resId) {
        showToast(cxt, cxt.getString(resId));
    }

    public static void showTipDialog(final Context cxt,
                                     final  String context) {
        showTipDialog(cxt, context, null);
    }

    public static void showTipDialog(final Context cxt,
                                     final int resId) {
        showTipDialog(cxt, resId, null);
    }

    public static void showTipDialog(final Context cxt,
                                     final int resId,
                                     final Runnable onPositive) {
        showTipDialog(cxt, cxt.getString(resId), onPositive);
    }

    public static void showTipDialog(final String content,
                                     final Runnable onPositive) {
        verifyContext();
        showTipDialog(getContext(), content, onPositive);
    }

    public static void showTipDialog(final Context cxt,
                                     final String content,
                                     final Runnable onPositive) {

        AppBase.runOnDispatcher(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(cxt);
                builder.setMessage(content);
                builder.setPositiveButton(R.string.text_common_confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (null != onPositive) {
                            onPositive.run();
                        }
                    }
                });
            }
        });
    }

    public static void showConfirmDialog(final String title,
                                         final String content,
                                         final String positiveText,
                                         final String negateText,
                                         final Runnable onPositive,
                                         final Runnable onNegative) {

        verifyContext();

        showConfirmDialog(getContext(), title, content, positiveText, negateText, onPositive, onNegative);
    }

    public static void showConfirmDialog(final Context cxt,
                                         final String title,
                                         final String content,
                                         final String positiveText,
                                         final String negateText,
                                         final Runnable onPositive,
                                         final Runnable onNegative) {

        AppBase.runOnDispatcher(new Runnable() {
            @Override
            public void run() {

                AlertDialog.Builder builder = new AlertDialog.Builder(cxt);
                builder.setTitle(title);
                builder.setMessage(content);
                builder.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (onPositive != null) {
                            onPositive.run();
                        }
                    }
                });
                builder.setNegativeButton(negateText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (onNegative != null) {
                            onNegative.run();
                        }
                    }
                });
                builder.create().show();
            }
        });
    }

    private static void verifyContext() {
        if(getContext() == null ) {
            throw new IllegalArgumentException("must be invoke setContext before");
        }
    }
}
