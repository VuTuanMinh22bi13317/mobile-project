package vn.edu.usth.mobile_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Write extends Fragment {

    private ImageButton addFileButton;
    private ImageButton sendEmailButton;
    private ImageButton moreOptionsButton;
    private ImageButton fromArrowButton;
    private ImageButton toArrowButton;

    private EditText fromEmailField;
    private EditText toEmailField;

    public Write() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_write, container, false);

        // Initialize buttons
        addFileButton = view.findViewById(R.id.add_files_button);
        sendEmailButton = view.findViewById(R.id.send_email_button);
        moreOptionsButton = view.findViewById(R.id.down_arrow_button);

        fromArrowButton = view.findViewById(R.id.from_arrow_button);
        toArrowButton = view.findViewById(R.id.to_arrow_button);

        fromEmailField = view.findViewById(R.id.input_email);
        toEmailField = view.findViewById(R.id.input_to_email);

        // Set listeners for the three main buttons
        setButtonListeners();

        // Set listeners for the down arrow buttons
        setupDropdownMenus();

        return view;
    }

    private void setButtonListeners() {
        addFileButton.setOnClickListener(v -> openFilePicker());
        sendEmailButton.setOnClickListener(v -> sendEmail());
        moreOptionsButton.setOnClickListener(v -> showMoreOptions());
    }

    private void setupDropdownMenus() {
        // Setup dropdown for the "From" email field
        fromArrowButton.setOnClickListener(v -> showEmailDropdown(fromArrowButton, fromEmailField));

        // Setup dropdown for the "To" email field
        toArrowButton.setOnClickListener(v -> showEmailDropdown(toArrowButton, toEmailField));
    }

    private void showEmailDropdown(View anchor, EditText emailField) {
        // Create a PopupMenu to show email options
        PopupMenu popupMenu = new PopupMenu(getActivity(), anchor);

        // Add email options (you can modify this with dynamic data or pull from a database)
        popupMenu.getMenu().add("email1@example.com");
        popupMenu.getMenu().add("email2@example.com");
        popupMenu.getMenu().add("email3@example.com");

        // Handle email selection
        popupMenu.setOnMenuItemClickListener(item -> {
            // Set the selected email in the EditText field
            emailField.setText(item.getTitle());
            return true;
        });

        // Show the popup menu
        popupMenu.show();
    }

    private void openFilePicker() {
        // Logic to open file picker
        Toast.makeText(getActivity(), "Opening file picker...", Toast.LENGTH_SHORT).show();
    }

    private void sendEmail() {
        // Logic to send email
        Toast.makeText(getActivity(), "Sending email...", Toast.LENGTH_SHORT).show();
    }

    private void showMoreOptions() {
        // Logic for more options (e.g., saving drafts)
        Toast.makeText(getActivity(), "Showing more options...", Toast.LENGTH_SHORT).show();
    }
}
