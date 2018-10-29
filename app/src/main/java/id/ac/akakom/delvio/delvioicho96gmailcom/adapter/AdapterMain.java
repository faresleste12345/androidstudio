package id.ac.akakom.delvio.delvioicho96gmailcom.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import id.ac.akakom.delvio.delvioicho96gmailcom.R;

/**
 * Created by root on 22/01/17.
 */

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {

    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;

    Context contetxt;
    ArrayList<Integer> listViewType;

    public AdapterMain(ArrayList<Integer> listViewType, Context contetxt) {
        this.listViewType = listViewType;
        this.contetxt = contetxt;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tipe_pertama, null);
                return new ItemPertamaViewHolder(view);
            case TYPE_2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tipe_kedua, null);
                return new ItemKeduaViewHolder(view);
            case TYPE_3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tipe_ketiga, null);
                return new ItemKetigaViewHolder(view);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int viewType = listViewType.get(position);
        switch (viewType) {
            case TYPE_1:
                ItemPertamaViewHolder itemPertamaViewHolder = (ItemPertamaViewHolder) holder;
                itemPertamaViewHolder.textViewItemPertama.setText("View Type tipe pertama dengan position: " + position);
                break;
            case TYPE_2:
                ItemKeduaViewHolder itemKeduaViewHolder = (ItemKeduaViewHolder) holder;
                itemKeduaViewHolder.textViewItemKedua.setText("View Type tipe kedua dengan position: " + position);
                break;
            case TYPE_3:
                ItemKetigaViewHolder itemKetigaViewHolder = (ItemKetigaViewHolder) holder;
                itemKetigaViewHolder.textViewItemKetiga.setText("Nama lengkap[" + position + "]");
        }
    }

    @Override
    public int getItemCount() {
        return listViewType.size();
    }

    @Override
    public int getItemViewType(int position) {
        return listViewType.get(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    class ItemPertamaViewHolder extends ViewHolder {

        //  komponen
        TextView textViewItemPertama;

        public ItemPertamaViewHolder(View itemView) {
            super(itemView);
            textViewItemPertama = (TextView) itemView.findViewById(R.id.text_view_item_tipe_pertama);
        }
    }

    class ItemKeduaViewHolder extends ViewHolder {

        //  komponen
        TextView textViewItemKedua;
        Button buttonOkItemKedua;

        public ItemKeduaViewHolder(final View itemView) {
            super(itemView);
            textViewItemKedua = (TextView) itemView.findViewById(R.id.text_view_item_tipe_kedua);
            buttonOkItemKedua = (Button) itemView.findViewById(R.id.button_ok_item_tipe_kedua);
            buttonOkItemKedua.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(contetxt, textViewItemKedua.getText().toString(), Toast.LENGTH_LONG)
                            .show();
                }
            });
        }
    }

    class ItemKetigaViewHolder extends ViewHolder {

        //  komponen
        TextView textViewItemKetiga;
        EditText editTextItemKetiga;
        Button buttonItemKetiga;

        public ItemKetigaViewHolder(View itemView) {
            super(itemView);
            textViewItemKetiga = (TextView) itemView.findViewById(R.id.text_view_item_tipe_ketiga);
            editTextItemKetiga = (EditText) itemView.findViewById(R.id.edit_text_nama_lengkap_item_tipe_ketiga);
            buttonItemKetiga = (Button) itemView.findViewById(R.id.button_ok_item_tipe_ketiga);
            buttonItemKetiga.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (TextUtils.isEmpty(editTextItemKetiga.getText().toString())) {
                        Toast.makeText(contetxt, textViewItemKetiga.getText().toString() + " belum di isi", Toast.LENGTH_LONG)
                                .show();
                        editTextItemKetiga.setError("Belum di isi");
                    } else {
                        Toast.makeText(contetxt, editTextItemKetiga.getText().toString(), Toast.LENGTH_LONG)
                                .show();
                    }
                }
            });
        }
    }
}
