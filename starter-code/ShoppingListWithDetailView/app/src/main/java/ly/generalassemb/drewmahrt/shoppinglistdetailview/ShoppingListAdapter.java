package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by drewmahrt on 10/21/16.
 */

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingItemViewHolder> {
    private List<ShoppingItem> mShoppingItems;
    ShoppingListFragment.OnShoppingItemSelectedListener mListener;

    public ShoppingListAdapter(List<ShoppingItem> shoppingItems, ShoppingListFragment.OnShoppingItemSelectedListener listener) {
        mShoppingItems = shoppingItems;
        mListener = listener;
    }

    @Override
    public ShoppingItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShoppingItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false));
    }

    @Override
    public void onBindViewHolder(final ShoppingItemViewHolder holder, final int position) {

        final ShoppingItem currentItem = mShoppingItems.get(position);

        holder.mNameTextView.setText(currentItem.getName());

        // Add an OnClickListener that launches DetailActivity and passes it the item's ID
        holder.mNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              mListener.onShoppingItemSelected(mShoppingItems.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mShoppingItems.size();
    }
}
